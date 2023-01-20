<template>
	<div id="MainBox">
		<h1>学生信息页面</h1>
		<!-- <el-button @click="to"></el-button> -->
		<div id="ButtonBox">
			<el-input class="QueryInput" v-model="keyWords" placeholder="请输入序号/关键词"></el-input>
			<el-button class="button" size="medium" plain @click="queryDataByid(keyWords)">检索</el-button>
			<el-button class="button" size="medium" type="primary" plain @click="dialogAddData = true">添加</el-button>
			<el-button class="button" size="medium" type="success" plain @click="showEditDialog">修改</el-button>
			<el-button class="button" size="medium" type="danger" plain @click="removeData">删除</el-button>
		</div>
		<div id="TableBox">
			<el-table :data="tableData" style="width: 100%;" height="800px" header-align="center"
				@selection-change="handleSelectionChange" :row-style="{height: '30px'}">
				<el-table-column type="selection" width="50">
				</el-table-column>
				<el-table-column prop="id" label="序号" align="center" show-overflow-tooltip>
					<template slot-scope="scope">
						<span style="margin-left: 10px">{{ scope.row.id }}</span>
					</template>
				</el-table-column>
				<el-table-column prop="name" label="姓名" align="center" show-overflow-tooltip>
					<template slot-scope="scope">
						<el-popover trigger="hover" placement="top">
							<p>姓名: {{ scope.row.name }}</p>
							<p>学院: {{ scope.row.college }}</p>
							<div slot="reference" class="name-wrapper">
								<el-tag size="medium">{{ scope.row.name }}</el-tag>
							</div>
						</el-popover>
					</template>
				</el-table-column>
				<el-table-column prop="age" label="年龄" align="center" show-overflow-tooltip>
					<template slot-scope="scope">
						<i class="el-icon-time"></i>
						<span style="margin-left: 10px">{{ scope.row.age }}</span>
					</template>
				</el-table-column>
				<el-table-column prop="sex" label="性别" align="center" show-overflow-tooltip>
					<template slot-scope="scope">
						<el-tag size="medium">{{ scope.row.sex }}</el-tag>
					</template>
				</el-table-column>
				<el-table-column prop="sid" label="学号" align="center" show-overflow-tooltip>
					<template slot-scope="scope">
						<!-- <i class="el-icon-time"></i> -->
						<span style="margin-left: 10px">{{ scope.row.sid }}</span>
					</template>
				</el-table-column>
				<!-- <el-table-column prop="Department" label="科室" align="center" show-overflow-tooltip>
          <template slot-scope="scope">
            <el-tag size="medium">{{ departments[scope.row.Department] ? departments[scope.row.Department].Name : '未知' }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="Doctor" label="医生" align="center" show-overflow-tooltip>
          <template slot-scope="scope">
            <el-tag size="medium">{{ doctors[scope.row.Doctor]? doctors[scope.row.Doctor].Name : '未知'}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="Category" label="挂号类别" align="center">
          <template slot-scope="scope">
            <el-tag size="medium">{{ scope.row.Category == 0 ? '普通门诊' : '专家门诊' }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="Cost" label="挂号费" align="center" show-overflow-tooltip>
        </el-table-column> -->
			</el-table>

			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="pageSize"
				layout="total, sizes, prev, pager, next, jumper" :total="total">
			</el-pagination>
		</div>

		<!-- 添加信息对话框 -->
		<el-dialog title="新增" :visible.sync="dialogAddData">
			<el-form :model="AddDataForm">

				<el-form-item label="学号" :label-width="formLabelWidth">
					<el-input v-model="AddDataForm.sid" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="姓名" :label-width="formLabelWidth">
					<el-input v-model="AddDataForm.name" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="年龄" :label-width="formLabelWidth">
					<el-input v-model="AddDataForm.age" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="性别" :label-width="formLabelWidth">
					<el-radio-group v-model="AddDataForm.sex">
						<el-radio label="男" value="男">男</el-radio>
						<el-radio label="女" value="女">女</el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="学院" :label-width="formLabelWidth">
					<el-input v-model="AddDataForm.college" autocomplete="off"></el-input>
				</el-form-item>

				<!-- <el-form-item label="科室" :label-width="formLabelWidth">
          <el-select v-model="AddDataForm.Department" placeholder="请选择科室" @change="changeDepartment">
            <el-option v-for="(item, index) in departmentList" :key="index" :label="item.Name" :value="item.Id">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="医生" :label-width="formLabelWidth">
          <el-select v-model="AddDataForm.Doctor" placeholder="请选择医生">
            <el-option v-for="(item, index) in doctorList" :key="index" :label="item.Name" :value="item.Id"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="挂号类型" :label-width="formLabelWidth">
          <el-radio-group v-model="AddDataForm.Category">
            <el-radio label="0">普通门诊</el-radio>
            <el-radio label="1">专家门诊</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="挂号费用" :label-width="formLabelWidth">
          <el-input v-model="AddDataForm.Cost" autocomplete="off"></el-input>
        </el-form-item> -->

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialogAddData = false">取 消</el-button>
				<el-button type="primary" @click="addData">确 定</el-button>
			</div>
		</el-dialog>
     
		 
		 <!-- 查询信息框 -->
		<el-dialog title="查询结果" :visible.sync="dialogVisible" width="50%" :before-close="handleClose">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item label="姓名">
					<el-input v-model="form.name"></el-input>
				</el-form-item>
				<el-form-item label="年龄">
					<el-input-number v-model="form.age" @change="handleChange" :min="1" :max="200" label="年龄">
					</el-input-number>
				</el-form-item>
				<el-form-item label="性别">
					<el-select v-model="form.sex" placeholder="请选择性别">
						<el-option label="男" value="man"></el-option>
						<el-option label="女" value="woman"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="学号">
					<el-input v-model="form.sid"></el-input>
				</el-form-item>
				<el-form-item label="学院">
					<el-input v-model="form.college"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="dialogVisible = false">取 消</el-button>
				<el-button type="primary" @click="dialogVisible = false">确 定</el-button>
			</span>
		</el-dialog>

		<!-- 修改信息对话框 -->
		<el-dialog title="修改" :visible.sync="dialogEditData">
			<el-form :model="EditDataForm">

				<el-form-item label="姓名" :label-width="formLabelWidth">
					<el-input v-model="EditDataForm.name" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="学院" :label-width="formLabelWidth">
					<el-input v-model="EditDataForm.college" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="年龄" :label-width="formLabelWidth">
					<el-input v-model="EditDataForm.age" autocomplete="off"></el-input>
				</el-form-item>

				<el-form-item label="性别" :label-width="formLabelWidth">
					<el-radio-group v-model="EditDataForm.sex">
						<el-radio label="男">男</el-radio>
						<el-radio label="女">女</el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="学号" :label-width="formLabelWidth">
					<el-input v-model="EditDataForm.sid" autocomplete="off"></el-input>
				</el-form-item>

				<!-- <el-form-item label="科室" :label-width="formLabelWidth">
					<el-select v-model="EditDataForm.Department" placeholder="请选择活动区域" @change="changeDepartment">
						<el-option v-for="(item, index) in departmentList" :key="index" :label="item.Name"
							:value="item.Id">
						</el-option>
					</el-select>
				</el-form-item> -->

				<!-- <el-form-item label="医生" :label-width="formLabelWidth">
					<el-select v-model="EditDataForm.Doctor" placeholder="请选择活动区域">
						<el-option v-for="(item, index) in doctorList" :key="index" :label="item.Name" :value="item.Id">
						</el-option>
					</el-select>
				</el-form-item> -->

				<!-- <el-form-item label="挂号类型" :label-width="formLabelWidth">
					<el-radio-group v-model="EditDataForm.Category">
						<el-radio label="0">普通门诊</el-radio>
						<el-radio label="1">专家门诊</el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="挂号费用" :label-width="formLabelWidth">
					<el-input v-model="EditDataForm.Cost" autocomplete="off"></el-input>
				</el-form-item> -->

			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialogEditData = false">取 消</el-button>
				<el-button type="primary" @click="editData">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				dialogVisible: false,
				form: {
					name: '',
					sex: '',
					age:1,
					college:'',
					sid:''
				},
				//表格数据
				tableData: [],
				// 检索关键词
				keyWords: "",

				multipleSelection: [],
				currentPage: 10,
				pageSize: 10,
				total: 10,

				doctors: [],
				departments: [],

				// 下拉选择框相关数据
				doctorList: [],
				departmentList: [],

				// 添加操作 相关数据
				formLabelWidth: '120px',
				dialogAddData: false,
				AddDataForm: {
					name: '',
					age: '',
					sid: '',
					sex: '男',
					college: ''
				},

				dialogEditData: false,
				EditDataForm: {
					id:'',
					name: '',
					age: '',
					sid: '',
					sex: '',
					college: ''
				},

			}
		},
		mounted() {
			this.created();
		},
		methods: {
			to(){
				this.$router.push({path:'/Doctor'})
			},
			handleClose(done) {
				this.$confirm('确认关闭？')
					.then(_ => {
						done();
					})
					.catch(_ => {});
			},
			handleChange(value) {
				console.log(value);
			},
			handleSizeChange(val) {
				this.pageSize = val;
				this.getTableData();
			},
			handleCurrentChange(val) {
				this.currentPage = val;
				this.getTableData();
			},
			changeDepartment(val) {
				console.log(val);
				this.getDoctorListById(val);
			},
			/**
			 * @name: 获取学生列表
			 * @param {*}
			 * @return {*}
			 */
			created: function() {
				this.$axios.get('http://localhost:8081/studentOps').then(resp => {
					this.tableData = resp.data;
					// let temp = resp.data;
					// var pagecount = temp.length / this.pageSize;
					// for(var i = )
					this.total = this.tableData.length;
					console.log(this.total)
				}).catch(function(error) {
					console.log(error)
				})
			},
			/**
			 * @name: 查找学生
			 * @param {*}
			 * @return {*}
			 */
			queryDataByid: function(keyWords) {
				this.$axios.get('http://localhost:8081/ketones/' + keyWords).then(resp => {
					this.dialogVisible = true;
					this.form = resp.data;
					console.log(resp.data)
				}).catch(function(error) {
					console.log(error)
					alert("不存在该学生!!!")
				})
			},
			/**
			 * @name: 获取医生列表
			 * @param {*}
			 * @return {*}
			 */
			getDoctorList() {
				this.$axios.get('/Doctor/GetAll')
					.then(res => {
						console.log(res);

						let data = {};
						for (var item in res.data.response) {
							data[res.data.response[item].Id] = res.data.response[item];
						}
						this.doctors = data;
						console.log(data);
					})
			},
			/**
			 * @name: 获取医生列表通过科室id
			 * @param {*}
			 * @return {*}
			 */
			// getListById(id) {
			// 	//this.AddDataForm.Doctor = "";
			// 	//this.EditDataForm.Doctor = "";
			// 	this.$axios.get('http://localhost:8081/ketones/' + keyWords).then(resp => {
			// 		console.log(resp.data)
			// 		//return resp.data
			// 	}).catch(function(error) {
			// 		console.log(error)
			// 		alert("不存在该学生!!!")
			// 	})
			// },
			/**
			 * @name: 获取表格数据
			 * @param {*}
			 * @return {*}
			 */
			getTableData() {
				this.$axios.get('/RegisterRecord/GetTableData?page=' + this.currentPage + '&intPageSize=' + this.pageSize)
					.then(res => {
						// console.log(res);
						this.tableData = res.data.response.data;
						this.total = res.data.response.dataCount;
						this.pageSize = res.data.response.PageSize;
						this.currentPage = res.data.response.page;
					})
			},

			/**
			 * @name: 根据关键词查询表格数据
			 * @param {*}
			 * @return {*}
			 */
			queryDataByKey() {
				// console.log(this.keyWords)
				this.$axios.get('/RegisterRecord/GetTableData?key=' + this.keyWords + '&page=' + this.currentPage +
						'&intPageSize=' + this.pageSize)
					.then(res => {
						console.log(res);
						this.tableData = res.data.response.data;
						this.total = res.data.response.dataCount;
						this.pageSize = res.data.response.PageSize;
						this.currentPage = res.data.response.page;
					})
			},

			/**
			 * @name: 添加信息函数
			 * @param {*}
			 * @return {*}
			 */
			addData() {
				console.log(this.AddDataForm);
				//let that = this;
				this.$axios.post('http://localhost:8081/add', this.AddDataForm)
					.then(res => {
						this.$alert('添加成功', '消息', {
							confirmbuttonText: '确定',
							callback: action => {
								window.location.reload();
							}
						})
						//this.dialogAddData = false;
					})
			},

			/**
			 * @name: 监听表格多选的改变
			 * @param {*} val
			 * @return {*}
			 */
			handleSelectionChange(val) {
				this.multipleSelection = val;
			},

			/**
			 * @name: 显示修改对话框
			 * @param {*}
			 * @return {*}
			 */
			showEditDialog() {
				if (this.multipleSelection.length == 0) {
					this.$message.error('请选择相应的数据');
					return;
				} else if (this.multipleSelection.length > 1) {
					this.$message.error('只能选择一条数据进行修改');
					return;
				}
				// 打开修改数据对话框
				this.dialogEditData = true;

				// 给修改表单的数据赋值
				let data = this.multipleSelection[0];
                
				//this.getListById(data.id);

				this.EditDataForm.id = data.id;
				// this.EditDataForm.name = data.name;
				// this.EditDataForm.age = data.age;
				// this.EditDataForm.sex = data.sex;
				// this.EditDataForm.college = data.college;
				// this.EditDataForm.Doctor = Number(data.Doctor);
				// this.EditDataForm.Category = data.Category + "";
				// this.EditDataForm.Cost = data.Cost;
			},

			/**
			 * @name: 修改信息函数
			 * @param {*}
			 * @return {*}
			 */
			editData() {
				console.log(this.EditDataForm);
				this.$axios.post('http://localhost:8081/update', this.EditDataForm)
					.then(res => {
						//console.log(res.data)
						if(res.data == null) alert("编辑失败！");
						this.dialogEditData = false;
					})
			},

			/**
			 * @name: 删除信息函数
			 * @param {*}
			 * @return {*}
			 */
			removeData() {
				if (this.multipleSelection.length <= 0) {
					this.$message.error('请选择相应的数据');
					return;
				}else if (this.multipleSelection.length > 1) {
					this.$message.error('只能选择一条数据进行修改');
					return;
				}

				let ids = this.multipleSelection[0];
				console.log(ids.join());
				this.$axios.get('http://localhost:8081/delete/' + ids.id).then(resp => {
					this.$alert('删除成功', '消息', {
						confirmbuttonText: '确定',
						callback: action => {
							window.location.reload();
						}
					})
				}).catch(function(error) {
					console.log(error)
				})

				// this.$axios.get('http://localhost:8081/update/' + )
				// 	.then(res => {
				// 		this.getTableData();
				// 		this.dialogEditData = false;
				// 	})

			}
		}
	}
</script>

<style>
	#MainBox {
		height: 100%
	}

	#ButtonBox {
		height: 50px;
	}

	.QueryInput {
		margin-top: 10px;
		vertical-align: middle;
		width: 200px !important;
		margin-left: 25px;
		margin-right: 5px;
	}

	.QueryInput input {
		height: 35px;
	}

	#ButtonBox .button {
		vertical-align: middle;
		margin-top: 10px;
	}

	#TableBox {
		height: calc(100% - 80px);
		margin-right: 10px;
		margin-left: 25px;
	}
</style>
