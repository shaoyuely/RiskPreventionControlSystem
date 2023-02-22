import Vue from 'vue';
import VueRouter from 'vue-router';
// import HomeView from '../views/HomeView.vue';
import Login from '@/views/login/index.vue';
import Manage from '@/views/manage/index.vue'
import * as auth from '@/util/auth.js'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect:'login'
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
  },
  {
    path: '/manage',
    name: 'manage',
    component: Manage,
  },
  {
    path: '/calculate',
    name: 'calculate',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '@/views/calculate/index.vue'),
  },
];

const router = new VueRouter({
  routes,
});

router.beforeEach((to,from,next)=>{
  if(to.fullPath==='/login'){
    next();
  }
  if(!auth.getToken()){
    next({
      path:"/login",
    })
  }
  next();
})

export default router;
