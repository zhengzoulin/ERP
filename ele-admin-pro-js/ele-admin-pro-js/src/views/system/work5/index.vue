<template>
  <div>
    <vxe-toolbar ref="xToolbar" custom>
      <template #buttons>
        <vxe-button content="查询信息" @click="selectAllStudents"></vxe-button>
        <vxe-toolbar>
          <template #buttons>
            <vxe-button icon="vxe-icon-square-plus" @click="insertEvent()">新增</vxe-button>
          </template>
        </vxe-toolbar>
<!--        <vxe-button content="新增信息" @click="addStudent"></vxe-button>-->
      </template>
      <template #tools>
        <vxe-button type="text" icon="vxe-icon-question-circle-fill" class="tool-btn"></vxe-button>
        <vxe-button type="text" icon="vxe-icon-funnel" class="tool-btn" @click="funnelEvent"></vxe-button>
      </template>
    </vxe-toolbar>
    <vxe-table stripe
      :data="item.students">
      <vxe-column type="seq" width="60"></vxe-column>
      <vxe-column field="id" title="Id"></vxe-column>
      <vxe-column field="studentid" title="StudentId"></vxe-column>
      <vxe-column field="name" title="Name"></vxe-column>
      <vxe-column field="major" title="Major"></vxe-column>
      <vxe-column field="grade" title="Grade"></vxe-column>
      <vxe-column field="operate" title="Operate" #default="{ row }">
        <vxe-button type="text" status="primary" content="修改" @click="updateEvent(row)"></vxe-button>
        <vxe-button type="text" status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
      </vxe-column>
    </vxe-table>

    <!--  编辑弹窗-->
    <vxe-modal v-model="item.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="item.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="name" title="姓名" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.name" placeholder="请输入姓名"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="name" title="专业" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.major" placeholder="请输入专业"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="grade" title="年级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.grade" placeholder="请输如年级"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="submitEvent">提交</vxe-button>
            <vxe-button type="reset">重置</vxe-button>
          </template>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>


  </div>

</template>

<script >

import 'vxe-table/lib/style.css'
import {defineComponent, reactive, ref} from 'vue'
import request from "@/utils/request";
export default {
  name: "index",
  setup () {
    const item=reactive({
      students:[],
      status:false,
      addStatus:false,
      updateData:[],
      addData:[]
    })

    const selectAllStudents=async ()=>{
      const res=await request.get('/test/student/findAllStudents');
      console.log(res);
      item.students=res.data;
      console.log(item.students)
      return res
    }
    const deleteEvent=async (row)=>{
      alert(row.id)
      const res=await request.delete('/test/student/deleteStudent/'+row.id)
      console.log(res)
      if(res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))

    }

    const updateEvent=async (row)=>{
      item.status=true;
      item.updateData=row;
    }
    const submitEvent=async () => {
      console.log(item.updateData)
      item.status=false
      let data=item.updateData
      const res = await request.put('/test/student/updateStudent',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }


    const addStudent=async () => {
      item.addStatus=true
      item.addData={};
    }
    const addEvent=async () => {
      item.addStatus=false
      let data={
        studentid:item.addData.studentid,
        name:item.addData.name,
        major:item.addData.major,
        grade:item.addData.grade
      }
      console.log(data)
      const res=await request.put('/test/student/addStudent',data)
      console.log(item.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }


    return {
      item,
      // tableData,
      selectAllStudents,
      updateEvent,
      submitEvent,
      deleteEvent,
      addEvent,
      addStudent
    }
  }
}
</script>

<style scoped>

</style>



