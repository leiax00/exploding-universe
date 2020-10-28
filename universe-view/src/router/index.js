import Vue from 'vue';
import VueRouter from 'vue-router';
import NProcess from 'nprogress';
import 'nprogress/nprogress.css';
import userRouter from '@/router/modules/user';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import(/* webpackChunkName: "layout" */ '@/layout/index'),
  },
  userRouter,
  { path: '*', name: '404', component: () => import(/* webpackChunkName: "error" */ '@/views/404') },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  NProcess.start();
  next();
});

router.afterEach(() => {
  NProcess.done();
});

export default router;
