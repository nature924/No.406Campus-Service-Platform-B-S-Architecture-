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

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import jiedanxiangqing from '@/views/modules/jiedanxiangqing/list'
    import jiedanyuan from '@/views/modules/jiedanyuan/list'
    import news from '@/views/modules/news/list'
    import paotuirenwu from '@/views/modules/paotuirenwu/list'
    import shouhuodizhi from '@/views/modules/shouhuodizhi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yonghutousu from '@/views/modules/yonghutousu/list'
    import yuebiangengjil from '@/views/modules/yuebiangengjil/list'
    import dictionaryJiedanxiangqingStatus from '@/views/modules/dictionaryJiedanxiangqingStatus/list'
    import dictionaryJifen from '@/views/modules/dictionaryJifen/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionaryPaotuirenwu from '@/views/modules/dictionaryPaotuirenwu/list'
    import dictionaryPaotuirenwuStatus from '@/views/modules/dictionaryPaotuirenwuStatus/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryYonghutousu from '@/views/modules/dictionaryYonghutousu/list'
    import dictionaryYonghutousuYesno from '@/views/modules/dictionaryYonghutousuYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
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
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryJiedanxiangqingStatus',
        name: '接单状态',
        component: dictionaryJiedanxiangqingStatus
    }
    ,{
        path: '/dictionaryJifen',
        name: '类型',
        component: dictionaryJifen
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionaryPaotuirenwu',
        name: '任务类型',
        component: dictionaryPaotuirenwu
    }
    ,{
        path: '/dictionaryPaotuirenwuStatus',
        name: '任务状态',
        component: dictionaryPaotuirenwuStatus
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYonghutousu',
        name: '投诉类型',
        component: dictionaryYonghutousu
    }
    ,{
        path: '/dictionaryYonghutousuYesno',
        name: '投诉状态',
        component: dictionaryYonghutousuYesno
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/jiedanxiangqing',
        name: '接单详情',
        component: jiedanxiangqing
      }
    ,{
        path: '/jiedanyuan',
        name: '接单员',
        component: jiedanyuan
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/paotuirenwu',
        name: '跑腿任务',
        component: paotuirenwu
      }
    ,{
        path: '/shouhuodizhi',
        name: '收货地址',
        component: shouhuodizhi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yonghutousu',
        name: '用户投诉',
        component: yonghutousu
      }
    ,{
        path: '/yuebiangengjil',
        name: '余额变更记录',
        component: yuebiangengjil
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
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
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

export default router;
