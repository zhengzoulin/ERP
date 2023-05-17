<template>
  <div class="ele-body">
    <a-card title="基本信息" :bordered="false">
      <a-form
        class="ele-form-detail"
        :label-col="{ md: 2, sm: 4, xs: 6 }"
        :wrapper-col="{ md: 22, sm: 20, xs: 18 }"
      >
        <a-form-item label="账号">
          <div class="ele-text-secondary">{{ form.id }}</div>
        </a-form-item>
        <a-form-item label="商品名">
          <div class="ele-text-secondary">{{ form.name }}</div>
        </a-form-item>
        <a-form-item label="价格">
          <div class="ele-text-secondary">{{ form.price }}</div>
        </a-form-item>
        <a-form-item label="数量">
          <div class="ele-text-secondary">{{ form.nums }}</div>
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
  import { getGoods } from '@/api/goods/goods';
  const ROUTE_PATH = '/goods/goods/details';

  const { currentRoute } = useRouter();

  // 用户信息
  const { form, assignFields } = useFormData({
    id: undefined,
    name: '',
    price: '',
    nums: '',
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
