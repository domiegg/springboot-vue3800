import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import sutuofenshu from '@/views/modules/sutuofenshu/list'
    import discusssutuohuodong from '@/views/modules/discusssutuohuodong/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import sutuohuodong from '@/views/modules/sutuohuodong/list'
    import discussxiaoyuanzixun from '@/views/modules/discussxiaoyuanzixun/list'
    import zaixianbaoming from '@/views/modules/zaixianbaoming/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import storeup from '@/views/modules/storeup/list'
    import huodongqiandao from '@/views/modules/huodongqiandao/list'
    import xiaoyuanzixun from '@/views/modules/xiaoyuanzixun/list'
    import messages from '@/views/modules/messages/list'
    import config from '@/views/modules/config/list'
    import huodongleixing from '@/views/modules/huodongleixing/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/sutuofenshu',
        name: '积分修改',
        component: sutuofenshu
      }
      ,{
	path: '/discusssutuohuodong',
        name: '活动发布评论',
        component: discusssutuohuodong
      }
      ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
      ,{
	path: '/sutuohuodong',
        name: '活动发布',
        component: sutuohuodong
      }
      ,{
	path: '/discussxiaoyuanzixun',
        name: '校园资讯评论',
        component: discussxiaoyuanzixun
      }
      ,{
	path: '/zaixianbaoming',
        name: '报名管理',
        component: zaixianbaoming
      }
      ,{
	path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
      ,{
	path: '/storeup',
        name: '我的收藏',
        component: storeup
      }
      ,{
	path: '/huodongqiandao',
        name: '签到人员',
        component: huodongqiandao
      }
      ,{
	path: '/xiaoyuanzixun',
        name: '校园资讯',
        component: xiaoyuanzixun
      }
      ,{
	path: '/messages',
        name: '留言板',
        component: messages
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/huodongleixing',
        name: '活动类型',
        component: huodongleixing
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
