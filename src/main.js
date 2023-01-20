// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/index.js'
import 'element-ui/lib/theme-chalk/index.css';
import ElementUI from  'element-ui';
import axios from 'axios';
import HelloWorld from './views/HelloWorld.vue'
import Department from './views/Department.vue'
import global from './global.js'

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.prototype.$apis = true

axios.defaults.baseURL='https://bmeit.cn/base_api';
axios.defaults.timeout=60000;
axios.defaults.headers.post['Content-Type']='application/json;charset=UTF-8';
Vue.prototype.$axios=axios;

Vue.prototype.global = global


router.beforeEach((to,from,next)=>{
	console.log("to",to);
	if(to.path != '/Department'&&this.apis == true){alert(111)}
	else {next()}
})

/* eslint-disable no-new */
new Vue({
  // router,
  // components:{App},
  // el:'#app',
  // template:'<App/>'
  router,
  components:{HelloWorld},
  el:'#app',
  template:'<HelloWorld/>'
  // router,
  // components:{Department},
  // el:'#app',
  // template:'<Department/>'
})
