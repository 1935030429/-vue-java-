<!-- helloworld.vue -->
<template>
  <el-container>
  <el-header style="height:99px">
    <div class="title" style="text-align:center">element-ui</div>
  </el-header>
  <el-main>

     <div class="background">
       <h1>挂号信息采集</h1>
       <!--门诊号-->
       <div class="content">
         <div class="ques">门诊号</div>
         <el-input class="anser" placeholder="请输入内容" v-model="input1" clearable></el-input>
       </div>

       <!--姓名-->
       <div class="content">
         <div class="ques">姓名</div>
         <el-input class="anser" placeholder="请输入内容" v-model="input2" clearable></el-input>
       </div>

       <!--年龄-->
       <div class="content">
         <div class="ques">年龄</div>
         <el-input class="anser" placeholder="请输入内容" v-model="input3" clearable></el-input>
       </div>

       <!--性别-->
       <div class="content">
          <div class="ques">性别</div>
           <div class="radio">
           <el-radio v-model="radio" label="男">男</el-radio>
           <el-radio v-model="radio" label="女">女</el-radio>
           </div>
       </div>

       <!--身份证号-->
       <div class="content">
         <div class="ques">身份证号</div>
         <el-input class="anser" placeholder="请输入内容" v-model="input4" clearable></el-input>
       </div>

       <!--科室-->
       <div class="content">
         <div class="ques">科室</div>
         <el-select class="select" v-model="value1" clearable placeholder="请选择">
            <el-option
              v-for="item in options1"
                 :key="item.value"
                 :label="item.label"
                 :value="item.value">
            </el-option>
         </el-select>
       </div>

       <!--医生-->
       <div class="content">
         <div class="ques">医生</div>
         <el-select class="select" v-model="value2" clearable placeholder="请选择">
            <el-option
              v-for="item in options2"
                 :key="item.value"
                 :label="item.label"
                 :value="item.value">
            </el-option>
         </el-select>
       </div>

       <!--挂号类别-->
       <div class="content">
         <div class="ques">挂号类别</div>
            <el-checkbox-group v-model="checkList">
                <el-checkbox label="普通门诊"></el-checkbox>
                <el-checkbox label="专家门诊"></el-checkbox>
            </el-checkbox-group>
       </div>

       <!--挂号费-->
       <div class="content">
         <div class="ques">挂号费</div>
         <el-input class="anser" placeholder="请输入内容" v-model="input5" clearable></el-input>
       </div>
     </div>

    <el-button round class="button">取  消</el-button>
    <el-button type="primary" round class="button" @click="clickup">提  交</el-button>   

  </el-main>
  <el-footer>Footer</el-footer>
</el-container>

</template>

<script>
export default {
  name: 'HelloWorld',
  
  data(){
    return {
      input1:'',
      input2:'',
      input3:'',
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
    clickup(){
      this.$router.push({
        path:'/page1',
        query:{
          id:this.input1,
          name:this.input2,
          age:this.input3,
          sex:this.radio,
          addressid:this.input4,
          keshi:this.value1,
          doctor:this.value2,
          type:this.checkList[0],
          money:this.input5
        }
      })
    }
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
