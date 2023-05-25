<template>
  <div class="ele-body">
    <a-card title="基本信息" :bordered="false">
      <a-form
        class="ele-form-detail"
        :label-col="{ md: 2, sm: 4, xs: 6 }"
        :wrapper-col="{ md: 22, sm: 20, xs: 18 }"
      >
<!--        <a-form-item label="原材料id">-->
<!--          <div class="ele-text-secondary">{{ form.id }}</div>-->
<!--        </a-form-item>-->
        <a-form-item label="协议编号">
          <div class="ele-text-secondary">{{ form.agreementNumber }}</div>
        </a-form-item>
        <a-form-item label="制定日期">
          <div class="ele-text-secondary">{{ form.makeDate }}</div>
        </a-form-item>
        <a-form-item label="供应商">
          <div class="ele-text-secondary">{{ form.agreementNumber }}</div>
        </a-form-item>
        <a-form-item label="供应原材料">
          <div class="ele-text-secondary">{{ form.supplyRawMaterials }}</div>
        </a-form-item>
        <a-form-item label="开始时间">
          <div class="ele-text-secondary">{{ form.beganTime }}</div>
        </a-form-item>
        <a-form-item label="结束时间">
          <div class="ele-text-secondary">{{ form.endTime }}</div>
        </a-form-item>
        <a-form-item label="联系人">
          <div class="ele-text-secondary">{{ form.rmsName }}</div>
        </a-form-item>
        <a-form-item label="联系方式">
          <div class="ele-text-secondary">{{ form.rmsPhone }}</div>
        </a-form-item>
        <a-form-item label="状态">
          <a-badge
            v-if="typeof form.status === 'number'"
            :status="['processing', 'error'][form.status]"
            :text="['正常', '冻结'][form.status]"
          />
        </a-form-item>

      </a-form>
    </a-card>
  </div>
</template>

<script setup>
  import { ref, watch, unref } from 'vue';
  import { useRouter } from 'vue-router';
  import { message } from 'ant-design-vue/es';
  import { toDateString } from 'ele-admin-pro/es';
  import useFormData from '@/utils/use-form-data';
  import { setPageTabTitle } from '@/utils/page-tab-util';
  import { getGoods } from '@/api/work/rawMaterial/purchaseAgreement';
  const ROUTE_PATH = '/work/api/work/sales/salesContract/details';

  const { currentRoute } = useRouter();

  // 用户信息
  const { form, assignFields } = useFormData({
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

  // 请求状态
  const loading = ref(true);

  /*  */
  const query = () => {
    const { query } = unref(currentRoute);
    const id = query.id;
    if (!id || form.id === Number(id)) {
      return;
    }
    loading.value = true;
    getGoods(Number(id))
      .then((data) => {
        loading.value = false;
        assignFields({
          ...data,
          createTime: toDateString(data.createTime)
        });
        // 修改页签标题
        if (unref(currentRoute).path === ROUTE_PATH) {
          setPageTabTitle(data.name + '的信息');
        }
      })
      .catch((e) => {
        loading.value = false;
        message.error(e.message);
      });
  };

  watch(
    currentRoute,
    (route) => {
      const { path } = unref(route);
      if (path !== ROUTE_PATH) {
        return;
      }
      query();
    },
    { immediate: true }
  );
</script>

<script>
  export default {
    name: 'SystemUserDetails'
  };
</script>
