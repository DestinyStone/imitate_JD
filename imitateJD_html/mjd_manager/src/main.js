import Vue from 'vue'
import App from './App.vue'
import VueCookie from "vue-cookie"
import router from "./router/BasicRouter"
import elementUI from "element-ui"
import store from "./store/index"
Vue.config.productionTip = false;
Vue.use(VueCookie);
Vue.use(elementUI);

new Vue({
  render: h => h(App),
  router,
  store,
  alert
}).$mount('#app');

