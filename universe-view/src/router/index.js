import Vue from 'vue';
import VueRouter from 'vue-router';
import NProcess from 'nprogress';
import 'nprogress/nprogress.css';
import { asyncRoutes, constantRoutes } from '@/router/ConstRouter';
import bus from '@/prop/util';

Vue.use(VueRouter);

const createRouter = () => new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: constantRoutes,
});

const router = createRouter();

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter();
  router.matcher = newRouter.matcher; // reset router
}

router.addRoutes(asyncRoutes);

router.beforeEach(async(to, from, next) => {
  NProcess.start();
  document.title = bus.getPageTitle(to.meta.title);
  next();
  // if (!getToken()) {
  //   if (whiteList.indexOf(to.path) !== -1) {
  //     next();
  //   } else {
  //     next(`/login?redirect=${to.path}`);
  //     NProcess.done();
  //   }
  //   return;
  // }
  //
  // if (to.path === '/login') {
  //   next({ path: '/' });
  //   NProcess.done();
  //   return;
  // }
  //
  // if (store.getters.roles && store.getters.roles.length > 0) {
  //   next();
  //   return;
  // }
  //
  // try {
  //   const { roles } = await store.dispatch('user/getInfo');
  //   const accessRoutes = await store.dispatch('permission/generateRoutes', roles);
  //   router.addRoutes(accessRoutes);
  //   next({ ...to, replace: true });
  // } catch (error) {
  //   await store.dispatch('user/resetToken');
  //   Message.error(error || 'Has Error');
  //   next(`/login?redirect=${to.path}`);
  //   NProcess.done();
  // }
});

router.afterEach(() => {
  NProcess.done();
});

export default router;
