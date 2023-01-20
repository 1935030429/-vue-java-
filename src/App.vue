<template>
  <div id="MainBox">
	  <div>
	  	  <router-link to={input1}>{{input1}}</router-link>
		  <router-view></router-view>
	  </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  
  data(){
    return {
      input1:'/Department',
      input2:'',
      input3:'',
	  input4:'',
	  input5:'',
      radio:'男',
      options1: [
        {
          value:'内科',
          label:'内科'
        },
        {
          value:'外科',
          label:'外科'
        },
        {
          value:'妇科',
          label:'妇科'
        },
        {
          value:'儿科',
          label:'儿科'
        },
        {
          value:'皮肤科',
          label:'皮肤科'
        }
      ],
      value1:'',
      options2: [
        {
          value:'医生1',
          label:'医生1'
        },
        {
          value:'医生2',
          label:'医生2'
        },
        {
          value:'医生3',
          label:'医生3'
        },
        {
          value:'医生4',
          label:'医生4'
        },
        {
          value:'医生5',
          label:'医生5'
        }
      ],
      value2:'',
      checkList: ['普通门诊']
    }
  },
  methods:{
  //   clickup(){
  //     this.$router.push({
		// //name:'App'
  //       path:'./HelloWorld',
  //       query:{
  //         id:this.input1,
  //         name:this.input2,
  //         age:this.input3,
  //         sex:this.radio,
  //         addressid:this.input4,
  //         keshi:this.value1,
  //         doctor:this.value2,
  //         type:this.checkList[0],
  //         money:this.input5
  //       }
  //     })
   // }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
   
   .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 70px;
  }

  .title {
    width: 85%;
    text-align: left;
    font-size: 52px;
    font-family: STHupo;
    color: #008c9e;
    line-height: 100px;
    padding-left: 50px;
  }

  .background {
    margin: 50px auto;
    padding: 20px;
    width: 50%;
    background-color: whitesmoke;
    border-radius: 20px;
  }

  .content {
    display: flex;
  }

  .ques {
    width: 26%;
    text-align: right;
    margin-right: 20px;
  }

  .anser {
    width: 50%;
  }

  .radio {
    line-height: 70px;
  }

  .select {
    width: 50%;
  }

  .button {
    position: relative;
    width: 150px;
    margin: auto 150px;
    font-size: 22px;
  }

</style>
