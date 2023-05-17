import { createApp } from 'vue';
import App from './App.vue';
import store from './store';
import router from './router';
import permission from './utils/permission';
import i18n from './i18n';
import './styles/index.less';
import 'xe-utils'
import VXETable from 'vxe-table'
import 'vxe-table/lib/style.css'

const app = createApp(App);

app.use(store);
app.use(router);
app.use(permission);
app.use(i18n);
app.use(VXETable)





// //vue3 基础组件的自动化全局注册
// const requireComponent = require.context(
//   // 其组件目录的相对路径
//   '@/components',
//   // 'C:\\model',
//   // 是否查询其子目录
//   true,
//   // 匹配基础组件文件名的正则表达式
//   /\.vue$/
// )
// requireComponent.keys().forEach(fileName => {
//   // debugger
//   // 获取组件配置
//   const componentConfig = requireComponent(fileName)
//   // 全局注册组件
//
//   app.component(
//     componentConfig.default.name,
//     // 如果这个组件选项是通过 `export default` 导出的，
//     // 那么就会优先使用 `.default`，
//     // 否则回退到使用模块的根。
//     componentConfig.default || componentConfig
//   )
// })

app.mount('#app');
