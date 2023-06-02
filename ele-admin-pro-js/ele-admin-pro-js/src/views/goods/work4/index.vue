<template>
  <div>
    <div>
      <vxe-toolbar ref="xToolbar" custom>
        <template #buttons>
          <vxe-button content="查询信息" @click="selectAllGoods"></vxe-button>
          <vxe-button content="新增信息" @click="addGoods"></vxe-button>
        </template>
        <template #tools>
          <vxe-button type="text" icon="vxe-icon-question-circle-fill" class="tool-btn"></vxe-button>
          <vxe-button type="text" icon="vxe-icon-funnel" class="tool-btn" @click="funnelEvent"></vxe-button>
        </template>
      </vxe-toolbar>
      <vxe-table
        stripe
        :data="item.goods">
        <vxe-column type="seq" width="60"></vxe-column>
        <vxe-column field="id" title="Id"></vxe-column>
        <vxe-column field="goodsid" title="GoodsId"></vxe-column>
        <vxe-column field="name" title="Name"></vxe-column>
        <vxe-column field="price" title="Price"></vxe-column>
        <vxe-column field="nums" title="Nums"></vxe-column>
        <vxe-column field="operate" title="Operate" #default="{ row }">
          <vxe-button type="text" status="primary" content="修改" @click="updateEvent(row)"></vxe-button>
          <vxe-button type="text" status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </vxe-column>
      </vxe-table>
      <!--  编辑弹窗-->
      <vxe-modal v-model="item.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
        <vxe-form :data="item.updateData" title-align="right" title-width="100" >
          <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
          <vxe-form-item field="name" title="商品名" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.name" placeholder="请输入商品名"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item field="price" title="价格" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.price" placeholder="请输入价格"></vxe-input>
            </template>
          </vxe-form-item>

          <vxe-form-item field="nums" title="数量" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.nums" placeholder="请输入数量"></vxe-input>
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
      <vxe-modal v-model="item.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
        <vxe-form :data="item.addData" title-align="right" title-width="100" >
          <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
          <vxe-form-item field="goodsid" title="编号" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.goodsid" placeholder="请输入编号"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item field="name" title="商品名" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.name" placeholder="请输入商品名"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item field="price" title="价格" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.price" placeholder="请输入价格"></vxe-input>
            </template>
          </vxe-form-item>

          <vxe-form-item field="nums" title="数量" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.nums" placeholder="请输入修改后数量"></vxe-input>
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


  </div>
</template>

<script >
import {defineComponent, reactive, ref} from 'vue'
import request from "@/utils/request";
export default {
  name: "index",
  setup () {
    const item=reactive({
      goods:[],
      status:false,
      addStatus:false,
      updateData:[],
      addData:[]
    })

    const selectAllGoods=async ()=>{
      const res=await request.get('/goods/goods/findAllGoods');
      // console.log(res);
      item.goods=res.data;
      // console.log(item.goods)
      console.log(res)
      return res
    }
    const deleteEvent=async (row)=>{
      alert("是否删除："+row.name)
      const res=await request.delete('/goods/goods/deleteGoods/'+row.id)
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
      const res = await request.put('/goods/goods/updateGoods',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const addGoods=async () => {
      item.addStatus=true
      item.addData={};
    }

    const addEvent=async () => {
      item.addStatus=false
      let data={
        goodsid:item.addData.goodsid,
        name:item.addData.name,
        price:item.addData.price,
        nums:item.addData.nums
      }
      console.log(data)
      const res=await request.put('/goods/goods/addGoods',data)
      console.log(item.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    return {
      item,
      // tableData,
      selectAllGoods,
      updateEvent,
      submitEvent,
      deleteEvent,
      addEvent,
      addGoods
    }
  }
}
</script>

<style scoped>

</style>
