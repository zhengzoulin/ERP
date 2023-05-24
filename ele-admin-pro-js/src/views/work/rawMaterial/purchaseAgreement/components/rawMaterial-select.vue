<!-- 角色选择下拉框 -->

<template>
  <a-select
    allow-clear
    mode="multiple"
    :value="id"
    :placeholder="placeholder"
    @update:value="updateValue"
    @blur="onBlur"
  >
    <!--    <a-select-option-->
    <!--      v-for="item in data"-->
    <!--      :key="item.roleId"-->
    <!--      :value="item.roleId"-->
    <!--    >-->
    <a-select-option
      v-for="item in data"
      :key="item.id"
      :value="item.id"
    >

      {{ item.id }} {{ item.supplyRawMaterials }}
    </a-select-option>

  </a-select>
</template>

<script setup>
import { ref, computed } from 'vue';
import { message } from 'ant-design-vue/es';
import request from "@/utils/request";
import { listRMs } from '@/api/work/rawMaterial/purchaseAgreement';

const emit = defineEmits(['update:value', 'blur']);

const props = defineProps({
  // 选中的角色
  value: Array,
  //
  placeholder: {
    type: String,
    default: '请选择原材料'
  }
});

// 选中的角色id
const id = computed(() => props.value?.map((d) => d.id));

// 角色数据
// const unitNames = ref([]);
// 原材料数据
const data = ref([]);


/* 更新选中数据 */
const updateValue = (value) => {
  emit(
    'update:value',
    value.map((v) => ({ id: v }))
  );
};

/* 获取角色数据 */
listRMs(data.value.id)
  .then((list) => {
    data.value = list;
  })
  .catch((e) => {
    message.error(e.message);
  });

/* 失去焦点 */
const onBlur = () => {
  emit('blur');
};


</script>
