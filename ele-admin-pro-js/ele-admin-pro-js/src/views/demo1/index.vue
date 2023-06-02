<template>
  <h1>hello</h1>
  <h1>{{ demo.str }}</h1>

  <input type="text" v-model="demo.str"/>
  <button @click="fun" value="按钮">按钮</button>
  <table border="solid">
    <tr>
      <td>code</td>
      <td>name</td>
      <td>age</td>
      <td>actions</td>
    </tr>
    <tr v-for="(student,index) in students">
      <td>{{ index }}</td>
      <td  v-if="index%2==0">{{ student.code }}</td>
      <td v-else style="background-color: #8be9fd">{{ student.code }}</td>
      <td>{{
          student.name
        }}
      </td>
      <td>{{ student.age }}</td>
      <td><button @click="edit(student)">edit</button><button @click="remove(index)">delete</button></td>
    </tr>
  </table>

  <table>
    <tr><td>code</td><td><input type="text" v-model="student.code"/></td></tr>
    <tr><td>code</td><td><input type="text" v-model="student.name"/></td></tr>
    <tr><td>code</td><td><input type="number" v-model="student.age"/></td></tr>
    <tr><td><button>save</button></td></tr>
  </table>
</template>

<script>
import {reactive, ref} from "vue";

export default {
  name: "index",
  setup() {
    debugger
    //定义属性
    const demo = reactive({
      str: "helle word!",
      arrary: []
    })
    let student = ref({code: "001", name: "xcy", age: 18});
    const students = reactive([{code: "001", name: "xcy", age: 18},
      {code: "002", name: "zy", age: 19},
      {code: "002", name: "yy", age: 10},{code: "001", name: "xcy", age: 18},
      {code: "002", name: "zy", age: 19},
      {code: "002", name: "yy", age: 10}])
    //定义函数
    const fun = () => {
      alert(demo.str)
    }
    const edit=(stu)=>{
      console.log(stu)
      debugger
      student.value = stu;
      console.log(student)
    }
    const remove =(index)=>{
      students.splice(index, 1);
    }
    return {
      demo,
      fun,
      students,
      student,
      edit,
      remove,
    }
  }
}

</script>

<style scoped>

</style>
