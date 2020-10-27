const userRouter = {
  path: '/user',
  component: () => import(/* webpackChunkName: "layout" */ '@/layout/index'),
  redirect: '/user/login',
  children: [
    {
      path: 'login',
      name: 'login',
      component: () => import(/* webpackChunkName: "user" */ '@/views/user/Login'),
    },
    {
      path: 'register',
      name: 'register',
      component: () => import(/* webpackChunkName: "user" */ '@/views/user/Register'),
    },
  ],
};

export default userRouter;
