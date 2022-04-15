import {createApp} from 'vue';
import Antd from 'ant-design-vue';
import App from './App.vue';
import router from './router';
import store from './store';
import 'ant-design-vue/dist/antd.css';
import axios from "axios";

axios.defaults.baseURL = process.env.VUE_APP_SERVER;
axios.interceptors.request.use((config) => {
    console.log('请求参数：', config);
    return config;
},error => {
    return Promise.reject(error);
})
axios.interceptors.response.use((response)=>{
    console.log('返回结果：', response);
    return response;
},error => {
    return Promise.reject(error);
})

const app = createApp(App);
app.use(store).use(router).use(Antd).mount('#app');

console.log('环境：', process.env.NODE_ENV);