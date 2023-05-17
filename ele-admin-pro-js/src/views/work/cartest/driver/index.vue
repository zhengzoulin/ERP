<template>
  <div>
    <vxe-button status="primary" content="查询司机" @click="findDrivers()"></vxe-button>
    <vxe-button status="primary" content="新增司机" @click="addDriver()"></vxe-button>
    <vxe-input v-model="demo.conditionBydriverNumber" type="text" placeholder="输入司机工号查询"></vxe-input>
    <vxe-input v-model="demo.conditionBydriverName" type="text" placeholder="输入司机姓名查询"></vxe-input>
    <vxe-button status="primary" content="根据条件查询" @click="findByCondition()"></vxe-button>
    <vxe-table
      :data="demo.drivers">
      <vxe-column type="seq" width="60" field="id"></vxe-column>
      <vxe-column field="driverNumber" title="司机工号"></vxe-column>
      <vxe-column field="driverName" title="司机姓名"></vxe-column>
      <vxe-column field="driverType" title="司机类型"></vxe-column>
      <vxe-column field="driverTel" title="联系电话"></vxe-column>
      <vxe-column field="driverAccount" title="系统账号"></vxe-column>
<!--      field="driverStatus"-->
      <vxe-column  title="司机状态" >
        <template #default="{ row }">
          <a-switch
            :checked="row.driverStatus === 0"
            @change="(checked) => editStatus(checked, row)"
          />
        </template>

      </vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{ row }">
          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>


    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '修改'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="driverNumber" title="司机工号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverNumber" placeholder="请输入司机工号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="driverName" title="司机姓名" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverName" placeholder="请输入司机姓名"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="driverType" title="司机类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverType" placeholder="请输入司机类型"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="driverTel" title="司机电话" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverTel" placeholder="请输入司机电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="driverAccount" title="系统账号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverAccount" placeholder="请输入系统账号"></vxe-input>
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
    <vxe-modal v-model="demo.addStatus" :title=" '新增司机'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="driverNumber" title="司机工号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverNumber" placeholder="请输入司机工号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="driverName" title="司机姓名" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverName" placeholder="请输入司机姓名"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="driverType" title="司机类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverType" placeholder="请输入司机类型"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="driverTel" title="司机电话" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverTel" placeholder="请输入司机电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="driverAccount" title="系统账号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.driverAccount" placeholder="请输入系统账号"></vxe-input>
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
  </div>


</template>


<script>
import {reactive} from "vue";
// import {demoService} from "@/views/demo/demo"
import request from "@/utils/request";
export default {
  name: "index",
  setup(){
    const demo=reactive({
      drivers:[],
      status:false,
      addStatus:false,
      updateData:[],
      addData:[],
      conditionBydriverNumber:null,
      conditionBydriverName:null,
    })


    const findDrivers=async () => {
      console.log(111)
      const res = await request.get('/test/driver/findAllDrivers');
      console.log(res)
      demo.drivers=res.data.data
      console.log(demo.drivers)
      return res
    }

    const findByCondition =async () => {
      const res = await request.get('/test/driver/findByCondition/'+demo.conditionBydriverNumber+'/'+demo.conditionBydriverName);
      demo.conditionBydriverNumber= null
      demo.conditionBydriverName=null
      console.log(res)
      demo.drivers=res.data
      console.log(demo.drivers)
      return res
    }

    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }

    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status=false
      let data=demo.updateData
      const res = await request.put('/test/driver/updateDriver',data);
      if (res.data.code === 0) {
        alert(res.data.message)
        findDrivers()
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const deleteEvent=async (row) => {
      const res = await request.delete('/test/driver/deleteDriver/'+row.id)
      if (res.data.code==0){
        alert(res.data.message)
        findDrivers()
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }


    const addDriver=async () => {
      demo.addStatus=true
    }


    const addEvent=async () => {
      demo.addStatus=false
      let data={
        driverNumber:demo.addData.driverNumber,
        driverName:demo.addData.driverName,
        driverType:demo.addData.driverType,
        driverTel:demo.addData.driverTel,
        driverAccount:demo.addData.driverAccount,
        driverStatus:demo.addData.driverStatus,
      }
      console.log(data)
      const res=await request.put('/test/driver/addDriver',data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        alert("新增成功")
        findDrivers()
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    /**
     * 修改用户状态
     */
    const updateDriverStatus =async (driverNumber, driverStatus) => {
      let data={
        driverNumber:this.driverNumber,
        driverStatus:this.driverStatus,
      }
      const res = await request.put('/test/driver/status',data);
      console.log(data)
      console.log(res)
      console.log(res.data.message)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    /* 修改用户状态 */
    const editStatus = (checked, row) => {
      const driverStatus = checked ? 0 : 1;
      updateDriverStatus(row.driverNumber, driverStatus)
        .then((msg) => {
          row.driverStatus = driverStatus;
          message.success(msg);
        })
        .catch((e) => {
          message.error(e.message);
        });
    };

    return {
      demo,
      findDrivers,
      findByCondition,
      updateEvent,
      submitEvent,
      deleteEvent,
      addEvent,
      addDriver,
      editStatus,
      updateDriverStatus
    }
  },
}
</script>

<style scoped>

</style>
