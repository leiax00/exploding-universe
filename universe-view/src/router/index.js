import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Nprocess from 'nprogress';
import 'nprogress/nprogress.css';
import userRouter from '@/router/modules/user';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
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
  Nprocess.start();
  next();
});

router.afterEach(() => {
  Nprocess.done();
  console.log('bbbb');
});

export default router;
