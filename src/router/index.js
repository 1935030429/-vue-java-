import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/views/HelloWorld';
import Department from '@/views/Department';
import Doctor from '@/views/Doctor';
import Hospital from '@/views/Hospital';
import RegisterRecord from '@/views/RegisterRecord';
//import App from '@/App.vue'

Vue.use(Router)

//后期添加
// const OriginalPush = Router.prototype.push
// Router.prototype.push = function push(location){
// 	console.log(location)
// 	return OriginalPush.call(this, location).catch(err=>err)
// }

export default new Router({
	 routes: [{
			path: '/HelloWorld',
			name: 'HelloWorld',
			component: HelloWorld
		},
		{
			path: '/Department',
			name: 'Department',
			component: Department,
			// children:[
			// 	{
			// 		path: '/HelloWorld',
			// 		name: 'HelloWorld',
			// 		component: HelloWorld
			// 	}
			// ]
		},
		{
			path: '/Doctor',
			name: 'Doctor',
			component: Doctor
		},
		{
			path: '/Hospital',
			name: 'Hospital',
			component: Hospital
		},
		{
			path: '/RegisterRecord',
			name: 'RegisterRecord',
			component: RegisterRecord
		}
	]
})
