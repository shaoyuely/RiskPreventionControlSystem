import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import axios from 'axios'

import element from '@/util/element.js'
import * as auth from '@/util/auth.js'
import 'element-ui/lib/theme-chalk/index.css';


Vue.config.productionTip = false;
Vue.prototype.$axios = axios
Vue.use(element)
// Vue.prototype.$axios.defaults.baseURL='http://172.22.192.193:8080'
Vue.prototype.$axios.defaults.baseURL='http://192.168.1.3:8080'

Vue.prototype.$auth = auth

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
