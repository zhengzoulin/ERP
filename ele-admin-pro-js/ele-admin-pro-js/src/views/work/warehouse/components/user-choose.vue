<template>
  <a-modal
    :width="720"
    title="用户选择"
    :visible="visible"
    @update:visible="updateVisible"
    @ok="doChoose">
    <div style="padding-bottom: 15px;">
      <!-- 搜索表单 -->
      <a-form
        :model="where"
        :label-col="{md: {span: 6}, sm: {span: 24}}"
        :wrapper-col="{md: {span: 18}, sm: {span: 24}}">
        <a-row>
          <a-col :lg="8" :md="12" :sm="24" :xs="24">
            <a-form-item label="用户账号:">
              <a-input v-model:value="where.username" placeholder="请输入" allow-clear />
            </a-form-item>
          </a-col>
          <a-col :lg="8" :md="12" :sm="24" :xs="24">
            <a-form-item label="用户名:">
              <a-input v-model:value="where.nickname" placeholder="请输入" allow-clear />
            </a-form-item>
          </a-col>
          <a-col :lg="8" :md="12" :sm="24" :xs="24">
            <a-form-item class="ele-text-right" :wrapper-col="{span: 24}">
              <a-button type="primary" @click="reload">搜索</a-button>
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
      <!-- 数据表格 -->
      <ele-pro-table
        ref="tableRef"
        row-key="userId"
        :columns="columns"
        :datasource="datasource"
        :init-load="false"
        v-model:selection="selection">
      </ele-pro-table>
    </div>
  </a-modal>
</template>

<script lang="ts" setup>
import { ref, reactive, watch, onMounted, nextTick } from 'vue';
import { message } from 'ant-design-vue';
import type { EleProTable } from 'ele-admin-pro';
import type { DatasourceFunction, ColumnItem } from 'ele-admin-pro/es/ele-pro-table/types';
import type { User, UserParam } from '@/api/system/user/model';
import { pageUsers } from '@/api/system/user';

const props = defineProps<{
  visible?: boolean;
  sex?: string;
}>();

const emit = defineEmits<{
  (e: 'update:visible', visible?: boolean): void;
  (e: 'done', result?: User[]): void;
}>();

// 表格搜索条件
const where = reactive<UserParam>({
  username: '',
  nickname: ''
});

// 表格选中数据
const selection = ref<User[]>([]);

// 表格实例
const tableRef = ref<InstanceType<typeof EleProTable>>();

// 表格列配置
const columns = ref<ColumnItem[]>([
  {
    title: '用户账号',
    dataIndex: 'username',
    sorter: true
  },
  {
    title: '用户名',
    dataIndex: 'nickname',
    sorter: true
  },
  {
    title: '性别',
    dataIndex: 'sexName',
    sorter: true
  },
  {
    title: '手机号',
    dataIndex: 'phone',
    sorter: true,
  }
]);

// 表格数据源
const datasource: DatasourceFunction = ({ page, limit, where, orders }) => {
  return pageUsers({
    ...where,
    ...orders,
    page,
    limit,
    sex: props.sex
  });
};

/* 搜索 */
const reload = () => {
  tableRef?.value?.reload({ page: 1, where: where });
};

/* 完成选择 */
const doChoose = () => {
  if (!selection.value.length) {
    message.error('请选择数据');
    return;
  }
  updateVisible(false);
  emit('done', [...selection.value]);
};

/* 更新visible */
const updateVisible = (value) => {
  emit('update:visible', value);
}

watch(() => props.visible, (visible) => {
  if(visible) {
    selection.value = [];
    Object.assign(where, {
      username: '',
      nickname: ''
    });
    nextTick(() => {
      reload();
    });
  }
});

onMounted(() => {
  if(props.visible) {
    reload();
  }
});
</script>
