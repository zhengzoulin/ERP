<!-- 用户编辑弹窗 -->
<template>
  <ele-modal
    :width="680"
    :visible="visible"
    :confirm-loading="loading"
    :title="isUpdate ? '修改工程' : '新建工程'"
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
        <a-col :md="12" :sm="24" :xs="24">
<!--          <a-form-item label="工程ID" name="id">-->
<!--            <a-input-->
<!--              allow-clear-->
<!--              :maxlength="20"-->
<!--              placeholder="请输入工程id"-->
<!--              v-model:value="form.id"-->
<!--              @blur="validate('id', { trigger: 'blur' }).catch(() => {})"-->
<!--            />-->
<!--          </a-form-item>-->
          <a-form-item label="工程名称" name="engineeringName">
            <a-input
              allow-clear
              :maxlength="20"
              placeholder="请输入工程名称"
              v-model:value="form.engineeringName"
              @blur="validate('engineeringName', { trigger: 'blur' }).catch(() => {})"
            />
          </a-form-item>
          <a-form-item label="客户ID" name="unitId">
            <a-input
              allow-clear
              :maxlength="20"
              placeholder="请输入客户ID"
              v-model:value="form.unitId"
              @blur="validate('unitId', { trigger: 'blur' }).catch(() => {})"
            />
          </a-form-item>
        </a-col>
        <a-col :md="12" :sm="24" :xs="24">
          <a-form-item label="工程地址" name="engineeringAddress">
            <a-input
              allow-clear
              :maxlength="11"
              placeholder="请输入地址"
              v-model:value="form.engineeringAddress"
            />
          </a-form-item>
          <a-form-item label="距离" name="distance">
            <a-input
              allow-clear
              :maxlength="11"
              placeholder="请输入距离"
              v-model:value="form.distance"
            />
          </a-form-item>
          <a-form-item label="开工日期" name="beginTime">
            <a-date-picker
              class="ele-fluid"
              value-format="YYYY-MM-DD"
              placeholder="请选择开公日期"
              v-model:value="form.beginTime"
            />
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>
  </ele-modal>
</template>

<script setup>
  import { ref, reactive, watch,watchEffect,onMounted } from 'vue';
  import { message } from 'ant-design-vue/es';
  import { emailReg, phoneReg } from 'ele-admin-pro/es';
  import useFormData from '@/utils/use-form-data';
  import RoleSelect from './role-select.vue';
  import { addGoods, updateGoods } from '@/api/work/sales/engineering';

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
    engineeringName: '',
    unitId: '',
    engineeringAddress: '',
    distance: '',
    beginTime:'',
    status: '',
  });

  // // 表单验证规则
  // const rules = reactive({
  //   username: [
  //     {
  //       required: true,
  //       type: 'string',
  //       validator: (_rule, value) => {
  //         return new Promise((resolve, reject) => {
  //           if (!value) {
  //             return reject('请输入用户账号');
  //           }
  //           checkExistence('username', value, props.data?.userId)
  //             .then(() => {
  //               reject('账号已经存在');
  //             })
  //             .catch(() => {
  //               resolve();
  //             });
  //         });
  //       },
  //       trigger: 'blur'
  //     }
  //   ],
  // });

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
