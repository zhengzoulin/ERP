<template>

  <vxe-button status="primary" content="查询学生" @click="findStudents()"></vxe-button>
  <vxe-button status="primary" content="新增学生" @click="addStudent()"></vxe-button>
  <vxe-table
    :data="demo.students">
    <vxe-column type="seq" width="60" field="id"></vxe-column>
    <vxe-column field="studentid" title="studentId"></vxe-column>
    <vxe-column field="name" title="name"></vxe-column>
    <vxe-column field="grade" title="grade"></vxe-column>
    <vxe-column field="major" title="major"></vxe-column>
    <vxe-column title="操作" width="240">
      <template #default="{ row }">

        <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
        <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
      </template>
    </vxe-column>
  </vxe-table>

<!--  编辑弹窗-->
  <vxe-modal v-model="demo.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
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

<!--  新增弹窗-->
  <vxe-modal v-model="demo.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="demo.addData" title-align="right" title-width="100" >
      <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
      <vxe-form-item field="studentid" title="学号" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.studentid" placeholder="请输入姓名"></vxe-input>
        </template>
      </vxe-form-item>
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
          <vxe-button @click="addEvent">提交</vxe-button>
          <vxe-button type="reset">重置</vxe-button>
        </template>
      </vxe-form-item>
    </vxe-form>
  </vxe-modal>

</template>



<script>
import {reactive} from "vue";
import {demoService} from "@/views/demo/demo"
import request from "@/utils/request";

export default {
  name: "index",
  setup() {
    const demo=reactive({
      students: [],
      status:false,
      addStatus:false,
      updateData:[],
      addData:[]
    })
    const findStudents=async () => {
      console.log(111)
      const res = await request.get('/test/student/findAllStudents');
      console.log(res)
      demo.students=res.data
      console.log(demo.students)
      return res
    }
    const deleteEvent=async (row) => {
      alert(row.id)
      const res = await request.delete('/test/student/deleteStudent/'+row.id)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }
    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }

    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status=false
      let data=demo.updateData
      const res = await request.put('/test/student/updateStudent',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const addStudent=async () => {
      demo.addStatus=true
    }

    const addEvent=async () => {
      demo.addStatus=false
      let data={
        studentid:demo.addData.studentid,
        name:demo.addData.name,
        major:demo.addData.major,
        grade:demo.addData.grade
      }
      console.log(data)
      const res=await request.put('/test/student/addStudent',data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    return {
      demo,
      findStudents,
      deleteEvent,
      updateEvent,
      submitEvent,
      addStudent,
      addEvent
    }
  },

}

</script>

<style scoped>

</style>
