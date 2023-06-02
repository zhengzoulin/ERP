<template>
  <div class="ele-body">

    <vxe-modal v-model="demo1.value5" width="600" show-footer>
      <vxe-button status="primary" content="+添加"></vxe-button>
<!--      <vxe-button v-model="students.value.unit_Name"></vxe-button>-->
      <vxe-table
        stripe
        :span-method="colspanMethod"
        :data="students">
        <vxe-column type="seq" width="60"></vxe-column>
        <vxe-column field="location" title="库位"></vxe-column>
        <vxe-column field="MaterialId" title="原材料Id"></vxe-column>
        <vxe-column field="MaterialName" title="原材料名称"></vxe-column>
        <vxe-column field="current" title="当前库存量"></vxe-column>
        <vxe-column field="status" title="状态"></vxe-column>
        <vxe-column field="operate" title="Operate" #default="{ row }">
          <vxe-button type="text" status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </vxe-column>
      </vxe-table>
    </vxe-modal>




    <a-card :bordered="false">
      <!-- 搜索表单 -->
      <user-search :where="defaultWhere" @search="reload" />
      <!-- 表格 -->
      <ele-pro-table
        ref="tableRef"
        row-key="Id"
        :columns="columns"
        :datasource="datasource"
        v-model:selection="selection"
        :scroll="{ x: 1000 }"
        :where="defaultWhere"
        cache-key="proSystemUserTable"
      >
        <template #toolbar>
          <a-space>
            <a-button type="primary" class="ele-btn-icon" @click="openEdit()">
              <template #icon>
                <plus-outlined />
              </template>
              <span>新建</span>
            </a-button>
            <a-button
              danger
              type="primary"
              class="ele-btn-icon"
              @click="removeBatch"
            >
              <template #icon>
                <delete-outlined />
              </template>
              <span>删除</span>
            </a-button>
          </a-space>
        </template>


        <template #bodyCell="{ column, record }">
          <template v-if="column.key === 'unitName'">
            <router-link :to="'/work/warehouse/details?id=' + record.id">
              {{ record.MaterialName }}
            </router-link>
          </template>
          <template v-else-if="column.key === 'status'">
            <a-switch
              :checked="record.status === 0"
              @change="(checked) => editStatus(checked, record)"
            />
          </template>
          <template v-else-if="column.key === 'action'">
            <a-space>
<!--              <vxe-button content="供应原材料" @click="selectAllGoods(record)"></vxe-button>-->
              <a class="ele-text-warning" @click="selectAllGoods(record)">供应原材料</a>
              <a @click="openEdit(record)">修改</a>
              <a-divider type="vertical" />
              <a-divider type="vertical" />
              <a-popconfirm
                placement="topRight"
                title="确定要删除此用户吗？"
                @confirm="remove(record)"
              >
                <a class="ele-text-danger">删除</a>
              </a-popconfirm>
            </a-space>
          </template>
        </template>
      </ele-pro-table>
    </a-card>
    <!-- 编辑弹窗 -->
    <user-edit v-model:visible="showEdit" :data="current" @done="reload" />
    <!-- 导入弹窗 -->
    <user-import v-model:visible="showImport" @done="reload" />
  </div>
</template>

<script setup>
  import { createVNode, ref, reactive } from 'vue';
  import { message, Modal } from 'ant-design-vue/es';
  import {
    PlusOutlined,
    DeleteOutlined,
    UploadOutlined,
    ExclamationCircleOutlined
  } from '@ant-design/icons-vue';
  import { toDateString, messageLoading } from 'ele-admin-pro/es';
  import UserSearch from './components/user-search.vue';
  import UserEdit from './components/user-edit.vue';
  import UserImport from './components/user-import.vue';
  import {
    pageGoods,
    removeGoods,
    updateUserStatus,
    // updateUserPassword
  } from '@/api/work/warehouse';

  import request from "@/utils/request";
  import axios from 'axios'


  const demo1 = reactive({
    value5: false,
  })

  let students = ref([{id: "001",rawMaterialId: "",rrId: 1,unit_Name:"", supplyRawMaterials: "测试1", platformRawMaterials: "测试2",rmStatus: 1},
    {id: "002",rawMaterialId: "",rrId: 1,unit_Name:"", supplyRawMaterials: "测试3", platformRawMaterials: "测试4",rmStatus: 1},
    {id: "003",rawMaterialId: "",rrId: 1,unit_Name:"", supplyRawMaterials: "测试5", platformRawMaterials: "测试6",rmStatus: 1}])
  // let students=ref([])
  const selectAllGoods=async (record)=>{
    demo1.value5 = true
    // const res=await request.delete('/test/student/deleteStudent/'+row.id)
    const res=await request.get('/work/raw-material-supplier/find/'+record.id);
    console.log(res.data.data);
    students.value=res.data.data;
    // console.log(item.goods)
    console.log(res)
    return res
  }
  const deleteEvent=async (row)=>{
    alert("是否删除供应原材料："+row.supplyRawMaterials+" "+row.rrId+" "+row.rawMaterialId)
    const res=await request.delete('/work/raw-material-supplier/deleteRR/'+row.rrId)
    console.log(res)
    if(res.data.code==0){
      return res.data.message
    }

    await selectAllGoods(row)
    reload()
    return Promise.reject((new Error(res.data.message)))



  }



  //*****************************************************************************



  // 表格实例
  const tableRef = ref(null);

  // 表格列配置
  const columns = ref([
    {
      key: 'index',
      width: 48,
      align: 'center',
      fixed: 'left',
      hideInSetting: true,
      customRender: ({ index }) => index + (tableRef.value?.tableIndex ?? 0)
    },
    // {
    //   title: '单位id',     //此处为列表属性栏展示绑定
    //   key: 'id',
    //   dataIndex: 'id',
    //   sorter: true,
    //   showSorterTooltip: false,
    // },
    {
      title: '单位名称',
      key: 'unitName',
      dataIndex: 'unitName',
      sorter: true,
      showSorterTooltip: false
    },
    {
      title: '单位类型',
      dataIndex: 'unitType',
      align: 'center',
      sorter: true,
      showSorterTooltip: false
    },
    {
      title: '联系电话',
      dataIndex: 'rmsPhone',
      align: 'center',
      sorter: true,
      showSorterTooltip: false
    },
    {
      title: '联系地址',
      dataIndex: 'rmsAddress',
      width: 120,
      sorter: true,
      showSorterTooltip: false
    },
    {
      title: '采购员',
      dataIndex: 'userId',
      sorter: true,
      showSorterTooltip: false
    },

    {
      title: '状态',
      key: 'status',
      dataIndex: 'status',
      sorter: true,
      showSorterTooltip: false,
      width: 90,
      align: 'center'
    },
    {
      title: '备注',
      key: 'rmsRemarks',
      dataIndex: 'rmsRemarks',
      sorter: true,
      showSorterTooltip: false,
      width: 90,
      align: 'center'
    },
    {
      title: '操作',
      key: 'action',
      width: 200,
      align: 'center'
    }
  ]);



  // 表格选中数据
  const selection = ref([]);

  // 当前编辑数据
  const current = ref(null);

  // 是否显示编辑弹窗
  const showEdit = ref(false);

  // 是否显示用户导入弹窗
  const showImport = ref(false);

  // 默认搜索条件
  const defaultWhere = reactive({
    id: '',
    name: ''
  });

  // 表格数据源
  const datasource = ({ page, limit, where, orders }) => {
    return pageGoods({ ...where, ...orders, page, limit });
  };
  // 表格数据源
  const datasource2 = ({ page, limit, where, orders }) => {
    return pageGoods({ ...where, ...orders, page, limit });
  };

  /* 搜索 */
  const reload = (where) => {
    selection.value = [];
    tableRef?.value?.reload({ page: 1, where });
  };

  /* 打开编辑弹窗 */
  const openEdit = (row) => {
    current.value = row ?? null;
    showEdit.value = true;
  };

  /* 打开编辑弹窗 */
  const openImport = () => {
    showImport.value = true;
  };

  /* 删除单个 */
  const remove = (row) => {
    const hide = messageLoading('请求中..', 0);
    removeGoods(row.id)
      .then((msg) => {
        hide();
        message.success(msg);
        reload();
      })
      .catch((e) => {
        hide();
        message.error(e.message);
      });
  };

  /* 批量删除 */
  const removeBatch = () => {
    if (!selection.value.length) {
      message.error('请至少选择一条数据');
      return;
    }
    Modal.confirm({
      title: '提示',
      content: '确定要删除选中的用户吗?',
      icon: createVNode(ExclamationCircleOutlined),
      maskClosable: true,
      onOk: () => {
        const hide = messageLoading('请求中..', 0);
        removeUsers(selection.value.map((d) => d.userId))
          .then((msg) => {
            hide();
            message.success(msg);
            reload();
          })
          .catch((e) => {
            hide();
            message.error(e.message);
          });
      }
    });
  };

  /* 修改用户状态 */
  const editStatus = (checked, row) => {
    const status = checked ? 0 : 1;
    updateUserStatus(row.id, status)
      .then((msg) => {
        row.status = status;
        message.success(msg);
      })
      .catch((e) => {
        message.error(e.message);
      });
  };
</script>

<script>
  export default {
    name: 'SystemUser'
  };
</script>
