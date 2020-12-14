import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/styles/index.scss';
import i18n from '@/components/i18n';
import UvIcon from '@/components/icon';

Vue.config.productionTip = false;

Vue.use(ElementUI);
Vue.component('uv-icon', UvIcon);

new Vue({
  i18n,
  router,
  store,
  render: h => h(App),
}).$mount('#app');
