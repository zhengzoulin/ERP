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
        <a-col :md="12" :sm="24" :xs="24">
<!--          <a-form-item label="商品ID1" name="id">-->
<!--            <a-input-->
<!--              allow-clear-->
<!--              :maxlength="20"-->
<!--              placeholder="请输入商品id"-->
<!--              v-model:value="form.id"-->
<!--              @blur="validate('id', { trigger: 'blur' }).catch(() => {})"-->
<!--            />-->
<!--          </a-form-item>-->
          <a-form-item label="协议编号" name="agreementNumber">
            <a-input
              allow-clear
              :maxlength="15"
              placeholder="请输入协议编号"
              v-model:value="form.agreementNumber"
              @blur="validate('agreementNumber', { trigger: 'blur' }).catch(() => {})"
            />
          </a-form-item>
<!--          <a-form-item label="制定日期" name="makeDate">-->
<!--            <a-input-->
<!--              allow-clear-->
<!--              :maxlength="15"-->
<!--              placeholder="请输入制定日期"-->
<!--              v-model:value="form.makeDate"-->
<!--              @blur="validate('makeDate', { trigger: 'blur' }).catch(() => {})"-->
<!--            />-->
<!--          </a-form-item>-->
          <a-form-item label="制定日期">
            <a-date-picker
              class="ele-fluid"
              value-format="YYYY-MM-DD"
              placeholder="请选择制定日期"
              v-model:value="form.makeDate"
            />
          </a-form-item>
<!--          <el-form-item label="供应商xz">-->
<!--            &lt;!&ndash;          <el-input v-model="form.supplier" autocomplete="off"></el-input>&ndash;&gt;-->
<!--            <el-select style="width: 200px" v-model="form.unitNames" placeholder="请选择供应商"  suffix-icon="el-icon-message" class="ml-5" @click.native="unitNamesFindList">-->
<!--              <el-option-->
<!--                v-for="item in unitNames"-->
<!--                :key="item.unitName"-->
<!--                :label="item.unitName"-->
<!--                :value="item.unitName">-->
<!--              </el-option>-->
<!--            </el-select>-->
<!--          </el-form-item>-->

          <a-form-item label="供应商选择" name="unitNames">
            <role-select
              v-model:value="form.unitNames"
              @blur="validate('unitNames', { trigger: 'blur' }).catch(() => {})"
            />
          </a-form-item>
<!--          <a-form-item label="供应商选择" name="unitNames">-->
<!--            <sex-select-->
<!--              v-model:value="form.unitNames"-->
<!--              @blur="validate('unitNames', { trigger: 'blur' }).catch(() => {})"-->
<!--            />-->
<!--          </a-form-item>-->
          <a-form-item label="供应原材料" name="supplyRawMaterials">
            <a-input
              allow-clear
              :maxlength="15"
              placeholder="请输入供应原材料"
              v-model:value="form.supplyRawMaterials"
              @blur="validate('supplyRawMaterials', { trigger: 'blur' }).catch(() => {})"
            />
          </a-form-item>
<!--          <a-form-item label="开始供应时间" name="beganTime">-->
<!--            <a-input-->
<!--              allow-clear-->
<!--              :maxlength="15"-->
<!--              placeholder="请输入供应时间"-->
<!--              v-model:value="form.beganTime"-->
<!--              @blur="validate('beganTime', { trigger: 'blur' }).catch(() => {})"-->
<!--            />-->
<!--          </a-form-item>-->
         <div >
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
         </div>

          <a-col :md="80" :sm="24" :xs="24">
            <a-form-item label="联系人" name="rmsName">
              <a-input
                allow-clear
                :maxlength="30"
                placeholder="请输入联系人"
                v-model:value="form.rmsName"
              />
            </a-form-item>

            <a-form-item label="联系方式" name="rmsPhone">
              <a-input
                allow-clear
                :maxlength="30"
                placeholder="请输入联系方式"
                v-model:value="form.rmsPhone"
                @blur="validate('rmsPhone', { trigger: 'blur' }).catch(() => {})"
              />
            </a-form-item>
        </a-col>

<!--          <a-form-item label="备注" name="rmsRemarks">-->
<!--            <a-input-->
<!--              allow-clear-->
<!--              :maxlength="11"-->
<!--              placeholder="请输入备注"-->
<!--              v-model:value="form.rmsRemarks"-->
<!--            />-->
<!--          </a-form-item>-->
<!--          <a-form-item label="采购员" name="userId">-->
<!--            <a-input-->
<!--              allow-clear-->
<!--              :maxlength="11"-->
<!--              placeholder="请输入采购员"-->
<!--              v-model:value="form.userId"-->
<!--            />-->
<!--          </a-form-item>-->
        </a-col>
      </a-row>
    </a-form>
  </ele-modal>
</template>

<script setup>
  import { ref, reactive, watch } from 'vue';
  import { message } from 'ant-design-vue/es';
  import { emailReg, phoneReg } from 'ele-admin-pro/es';
  import useFormData from '@/utils/use-form-data';
  import RoleSelect from './role-select.vue';
  import SexSelect from './sex-select.vue';
  import { addGoods, updateGoods } from '@/api/work/rawMaterial/purchaseAgreement';

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
    agreementNumber: '',
    makeDate: '',
    rmsId:'',
    unitName: '',
    supplyRawMaterials: '',
    paRemarks:'',
    unitPrice:undefined,
    planQuantity:undefined,
    planTotal:undefined,
    beganTime: '',
    endTime:'',
    rmsName: '',
    rmsPhone: '',
    status: '',
  });

  const  unitNamesFindList=()=>{
    this.request.get("/unitNames").then(res => {
      this.unitNames = res.data

    })
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
