<template>
<div>

  <vxe-button content="自定义模板" @click="demo1.value5 = true"></vxe-button>
  <vxe-modal v-model="demo1.value5" width="600" show-footer>
    <template #title>
      <span style="color:red">自定义标题</span>
    </template>
    <template #corner>
      <vxe-icon name="bell-fill"></vxe-icon>
      <vxe-icon name="minus"></vxe-icon>
    </template>
    <template #default>
      <vxe-table
        show-overflow
        height="300"
        :sync-resize="demo1.value5"
        :data="demo1.tableData">
        <vxe-column type="seq" width="60"></vxe-column>
        <vxe-column field="name" title="Name"></vxe-column>
        <vxe-column field="sex" title="Sex"></vxe-column>
        <vxe-column field="age" title="Age"></vxe-column>
      </vxe-table>
    </template>
  </vxe-modal>
</div>

</template>

<script>
import { defineComponent, reactive } from 'vue'
import { VXETable } from 'vxe-table'

export default defineComponent({
  setup  () {
    const demo1 = reactive({
      value5: false,
      value6: false,
      value7: false,
      value8: false,
      value9: false,
      value10: false,
      value11: false,
      sexList: [
        { label: '', value: '' },
        { label: '女', value: '0' },
        { label: '男', value: '1' }
      ],
      formData3: {
        name: '',
        nickname: '',
        sex: '',
        age: 26,
        address: null
      },
      formRules3: {
        name: [
          { required: true, message: '请输入名称' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符' }
        ],
        nickname: [
          { required: true, message: '请输入昵称' }
        ],
        sex: [
          { required: true, message: '请选择性别' }
        ]
      },
      tablePage: {
        pageSize: 10
      },
      tableToolbar: {
        buttons: [
          { code: 'myBtn1', name: '按钮1' },
          { code: 'myBtn2', name: '按钮2' }
        ],
        refresh: true,
        custom: true
      },
      tableData: [
        { id: 10001, name: 'Test1', role: 'Develop', sex: 'Man', age: 28, address: 'test abc' },
        { id: 10002, name: 'Test2', role: 'Test', sex: 'Women', age: 22, address: 'Guangzhou' },
        { id: 10003, name: 'Test3', role: 'PM', sex: 'Man', age: 32, address: 'Shanghai' },
        { id: 10004, name: 'Test4', role: 'Designer', sex: 'Women', age: 24, address: 'Shanghai' }
      ],
      tableColumn: [
        { type: 'checkbox', width: 50 },
        { type: 'seq', width: 60 },
        { field: 'name', title: 'Name' },
        { field: 'nickname', title: 'Nickname' },
        {
          field: 'role',
          title: 'Role',
          filters: [
            { label: '前端', value: '前端' },
            { label: '后端', value: '后端' },
            { label: '设计师', value: '设计师' },
            { label: '管理员', value: '管理员' },
            { label: '项目经理', value: '项目经理' },
            { label: '测试', value: '测试' },
            { label: '美工', value: '美工' },
            { label: '数据库', value: '数据库' }
          ]
        },
        { field: 'describe', title: 'Describe' }
      ]
    })



    return {
      demo1,
    }
  }
})



</script>
