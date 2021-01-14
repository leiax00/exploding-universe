import UvLayout from '@/layout/index';
import userRouter from '@/router/modules/user';
import RoleConst from '@/prop/constant/RoleConst';

export const whiteList = ['/login', '/auth-redirect'];
export const constantRoutes = [
  {
    path: '/',
    name: 'Home',
    redirect: '/index',
    component: UvLayout,
    children: [
      {
        path: 'index',
        name: 'home',
        component: () => import(/* webpackChunkName: "user" */ '@/views/blog'),
        meta: { title: '首页', roles: [RoleConst.ROLE.ALL_ALLOW] },
      },
    ],
  },
  {
    path: '/404',
    component: () => import(/* webpackChunkName: "error" */ '@/views/error-page/404'),
    hidden: true,
  },
  {
    path: '/401',
    component: () => import(/* webpackChunkName: "error" */ '@/views/error-page/401'),
    hidden: true,
  },
  userRouter,
  { path: '*', name: '404', redirect: '/404' },
];

export const asyncRoutes = [
  {
    path: '/',
    redirect: '/index',
    component: UvLayout,
    children: [
      {
        path: '/md',
        name: 'md-editor',
        component: () => import(/* webpackChunkName: "error" */ '@/views/md-edit'),
      },
    ],
  },

];
