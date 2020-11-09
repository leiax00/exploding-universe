import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/styles/index.scss';
import i18n from '@/components/i18n';

Vue.config.productionTip = false;

Vue.use(ElementUI);

new Vue({
  i18n,
  router,
  store,
  render: h => h(App),
}).$mount('#app');
