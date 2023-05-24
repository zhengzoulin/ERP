<!-- 用户编辑弹窗 -->
<template>
  <ele-modal
    :width="680"
    :visible="visible"
    :confirm-loading="loading"
    :title="isUpdate ? '修改采购协议' : '新建采购协议'"
    :body-style="{ paddingBottom: '8px' }"
    @update:visible="updateVisible"
    @ok="save"
  >
    <a-form
      ref="formRef"
      :model="form"
      :rules="rules"
      :label-col="{ md: 7, sm: 4, xs: 24 }"
      :wrapper-col="{ md: 17, sm: 20, xs: 24 }"
    >
      <a-row :gutter="16">
        <a-form-item label="协议编号" name="agreementNumber">
          <a-input
            allow-clear
            :maxlength="15"
            placeholder="请输入协议编号"
            v-model:value="form.agreementNumber"
            @blur="validate('agreementNumber', { trigger: 'blur' }).catch(() => {})"
          />
        </a-form-item>
        <a-form-item label="制定日期">
          <a-date-picker
            class="ele-fluid"
            value-format="YYYY-MM-DD"
            placeholder="请选择制定日期"
            v-model:value="form.makeDate"
          />
        </a-form-item>

        <a-col :md="12" :sm="24" :xs="24">
          <a-form-item label="供应商选择" name="rawMaterialSuppliers">
            <role-select
              v-model:value="form.rawMaterialSuppliers"
              @blur="validate('rawMaterialSuppliers', { trigger: 'blur' }).catch(() => {})"
            />
          </a-form-item>
          <a-form-item label="供应原材料选择" name="rawMaterials">
            <raw-material-select
              v-model:value="form.rawMaterials"
              @blur="validate('rawMaterials', { trigger: 'blur' }).catch(() => {})"
            />
          </a-form-item>
        </a-col>
        <a-col :md="12" :sm="24" :xs="24">
          <a-form-item label="单价" name="unitPrice">
            <a-input
              allow-clear
              :maxlength="11"
              placeholder="请输入单价"
              v-model:value="form.unitPrice"
            />
          </a-form-item>
          <a-form-item label="计划数量" name="planQuantity">
            <a-input
              allow-clear
              :maxlength="11"
              placeholder="请输入计划数量"
              v-model:value="form.planQuantity"
            />
          </a-form-item>
          <a-form-item label="计划总额" name="planTotal">
            <a-input
              allow-clear
              :maxlength="11"
              placeholder="请输入总额"
              v-model:value="form.planTotal"  readonly
            />
          </a-form-item>
        </a-col>



        <a-form-item label="开始供应时间">
          <a-date-picker
            class="ele-fluid"
            value-format="YYYY-MM-DD"
            placeholder="请选择开始供应时间"
            v-model:value="form.beganTime"
          />
        </a-form-item>


        <a-form-item label="结束供应时间">
          <a-date-picker
            class="ele-fluid"
            value-format="YYYY-MM-DD"
            placeholder="请选择结束供应时间"
            v-model:value="form.endTime"
          />
        </a-form-item>

        <a-form-item label="联系人" name="rmsName">
          <a-input
            allow-clear
            :maxlength="20"
            placeholder="请输入联系人"
            v-model:value="form.rmsName"
          />
        </a-form-item>

        <a-form-item label="联系方式" name="rmsPhone">
          <a-input
            allow-clear
            :maxlength="20"
            placeholder="请输入联系方式"
            v-model:value="form.rmsPhone"
            @blur="validate('rmsPhone', { trigger: 'blur' }).catch(() => {})"
          />
        </a-form-item>


        <a-form-item label="备注" name="paRemarks">
          <a-input
            allow-clear
            :maxlength="11"
            placeholder="请输入备注"
            v-model:value="form.paRemarks"
          />
        </a-form-item>
        <!--          <a-form-item label="采购员" name="userId">-->
        <!--            <a-input-->
        <!--              allow-clear-->
        <!--              :maxlength="11"-->
        <!--              placeholder="请输入采购员"-->
        <!--              v-model:value="form.userId"-->
        <!--            />-->
        <!--          </a-form-item>-->

      </a-row>
    </a-form>
  </ele-modal>
</template>

<script setup>
import { ref, reactive, watch,watchEffect,onMounted  } from 'vue';
import { message } from 'ant-design-vue/es';
import { emailReg, phoneReg } from 'ele-admin-pro/es';
import useFormData from '@/utils/use-form-data';
import RoleSelect from './role-select.vue';
import SexSelect from './sex-select.vue';
import RawMaterialSelect from './rawMaterial-select.vue'
import { addGoods, updateGoods } from '@/api/work/rawMaterial/purchaseAgreement';
import request from "@/utils/request";
import computed from "@/utils/request";

// const {computed} = require("vue");

const emit = defineEmits(['done', 'update:visible']);

const props = defineProps({
  // 弹窗是否打开
  visible: Boolean,
  // 修改回显的数据
  data: Object
});

//
const formRef = ref(null);

// 是否是修改
const isUpdate = ref(false);

// 提交状态
const loading = ref(false);

// 表单数据
const { form, resetFields, assignFields } = useFormData({
  id: undefined,
  agreementNumber: ref('PA' + generateRandomNumber()),
  makeDate: '',
  rmsId: '',
  unitName: '',
  rawMaterialSuppliers:[],
  rawMaterials:[],
  supplyRawMaterials: '',
  paRemarks:'',
  unitPrice: 0,
  planQuantity: 0,
  planTotal: 0,
  beganTime: '',
  endTime:'',
  status: '',
});

// 监听单价和计划数量的变化，更新总价的值
watchEffect(() => {
  form.planTotal = form.unitPrice * form.planQuantity
})
// 生成10位随机数字字符串
function generateRandomNumber() {
  const min = 0
  const max = 9999999999
  const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min
  return String(randomNumber).padStart(10, '0')
}


// 获取最新的协议编号
function fetchLatestProtocolCode() {
  // TODO: 发送请求获取最新的协议编号
  return 'PA000123'
}


// 表单验证规则
const rules = reactive({

});

/* 保存编辑 */
const save = () => {
  if (!formRef.value) {
    return;
  }
  formRef.value
    .validate()
    .then(() => {
      loading.value = true;
      const saveOrUpdate = isUpdate.value ? updateGoods : addGoods;
      saveOrUpdate(form)
        .then((msg) => {
          loading.value = false;
          message.success(msg);
          updateVisible(false);
          emit('done');
        })
        .catch((e) => {
          loading.value = false;
          message.error(e.message);
        });
    })
    .catch(() => {});
};

/* 更新visible */
const updateVisible = (value) => {
  emit('update:visible', value);
};

watch(
  () => props.visible,
  (visible) => {
    if (visible) {
      if (props.data) {
        assignFields({
          ...props.data,
          password: ''
        });
        isUpdate.value = true;
      } else {
        isUpdate.value = false;
      }
    } else {
      resetFields();
      formRef.value?.clearValidate();
    }
  }
);
</script>
