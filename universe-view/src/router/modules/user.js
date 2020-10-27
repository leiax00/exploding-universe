const userRouter = {
  path: '/user',
  component: { render: h => h('router-view') },
  children: [
    {
      path: '/user/login',
      name: 'login',
      component: () => import(/* webpackChunkName: "user" */ '@/views/user/Login'),
    },
    {
      path: '/user/register',
      name: 'register',
      component: () => import(/* webpackChunkName: "user" */ '@/views/user/Register'),
    },
  ],
};

export default userRouter;
