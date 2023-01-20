<template>
	<div>
		<h1>老师信息页面</h1>
		<div id="MainBox">
			<div id="ButtonBox">
				<el-input class="QueryInput" v-model="key" placeholder="请输入关键词"></el-input>
				<el-button class="button" size="medium" plain @click="queryDataByKey">检索</el-button>
				<el-button class="button" size="medium" type="primary" plain @click="dialogAddData=true">添加</el-button>
				<el-button class="button" size="medium" type="success" plain>修改</el-button>
				<el-button class="button" size="medium" type="danger" plain>删除</el-button>
			</div>
			<div id="TableBox">
				<el-table :data="tableData" style="width: 100%" @selection-change="handleSelection"
					:row-style="{height:'30px'}">
					<el-table-column type="selection" width="50"></el-table-column>
					<el-table-column prop="id" label="序号" width="180" show-overflow-tooltip>
						<template slot-scope="scope">
							<el-tag size="medium">{{ scope.row.id }}</el-tag>
						</template>
					</el-table-column>
					<el-table-column prop="name" label="姓名" width="180" show-overflow-tooltip>
						<template slot-scope="scope">
							<el-popover trigger="hover" placement="top">
								<p>姓名: {{ scope.row.name }}</p>
								<p>教育背景: {{ scope.row.edubackground }}</p>
								<div slot="reference" class="name-wrapper">
									<el-tag size="medium">{{ scope.row.name }}</el-tag>
								</div>
							</el-popover>
							<!-- <el-tag size="medium">{{ scope.row.name }}</el-tag> -->
						</template>
					</el-table-column>
					<el-table-column prop="sex" label="性别" show-overflow-tooltip>
						<template slot-scope="scope">
							<el-tag size="medium">{{ scope.row.sex }}</el-tag>
						</template>
					</el-table-column>
					<el-table-column prop="age" label="年龄" show-overflow-tooltip>
					</el-table-column>
					<el-table-column prop="image" label="头像" style="height: 25%;" show-overflow-tooltip>
						<template slot-scope="scope">
							<el-image :src=" scope.row.image "></el-image>
						</template>
					</el-table-column>
					<el-table-column prop="Description" label="描述" show-overflow-tooltip>
					</el-table-column>
				</el-table>
				<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
					:current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="pageSize"
					layout="total, sizes, prev, pager, next, jumper" :total="total">
				</el-pagination>
			</div>

			<!-- 添加信息对话框 -->
			<el-dialog title="提示" :visible.sync="dialogAddData" width="50%" :before-close="handleClose">
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
							<el-option label="man" value="man"></el-option>
							<el-option label="women" value="women"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item label="职位">
						<el-input v-model="form.position"></el-input>
					</el-form-item>
					<el-form-item label="教育背景">
						<el-input v-model="form.edubackground"></el-input>
					</el-form-item>
					<el-form-item label="头像">
						<el-input v-model="form.image"></el-input>
					</el-form-item>
				</el-form>
				<span slot="footer" class="dialog-footer">
					<el-button @click="dialogAddData = false">取 消</el-button>
					<el-button type="primary" @click="AddData">确 定</el-button>
				</span>
			</el-dialog>

			<!-- 修改信息对话框 -->

			<!-- 检索信息框 -->
			<el-dialog title="检索结果" :visible.sync="dialogQurey" width="50%" :before-close="handleCloseTwo">
				<el-table :data="Types" style="width: 120%">
					<el-table-column prop="name" label="名称" width="180">
					</el-table-column>
					<el-table-column prop="sex" label="性别" width="180">
					</el-table-column>
					<el-table-column prop="position" label="职位">
					</el-table-column>
					<el-table-column prop="age" label="年龄">
					</el-table-column>
					<el-table-column prop="image" label="头像" height:20px>
						<el-image :src=" image " stlye="height:200px;"></el-image>
					</el-table-column>
					<el-table-column prop="edubackground" label="教育背景">
					</el-table-column>
				</el-table>
				<span slot="footer" class="dialog-footer">
					<el-button @click="dialogQurey = false">取 消</el-button>
					<!-- <el-button type="primary" @click="AddData">确 定</el-button> -->
				</span>
			</el-dialog>

		</div>
	</div>

</template>

<script>
	export default {
		name: 'Doctor',
		data() {
			return {
				form: {
					sex: '',
					edubackground: '',
					position: '',
					name: '',
					age: 1,
					image: 'https://tse4-mm.cn.bing.net/th/id/OIP-C.eXc3OFcBb0NP_gFpOV-U5wHaLH?w=204&h=306&c=7&r=0&o=5&dpr=1.25&pid=1.7'
				},
				tableData: [],
				multipleSelection: [],
				currentPage: 1,
				pageSize: 10,
				total: 0,
				key: '',
				Name: '',
				NickName: '',
				Address: '',
				Phone: '',
				Image: '',
				Description: '',
				Types: [],
				Status: '0',
				dialogAddData: false,
				dialogQurey: false
			}
		},
		mounted() {
			this.getTableData();
			//this.getHospital();
		},
		methods: {
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
			handleCloseTwo(done) {
				this.$confirm('确认关闭？').then(_ => {
						done();
					})
					.catch(_ => {});
			},
			handleSelection(val) {
				this.multipleSelection = val;
			},
			getTableData() {
				let that = this;
				this.$axios.get('http://localhost:8081/GetAllTeachers')
					.then(res => {
						console.log(res.data);
						that.tableData = res.data;
						that.total = res.data.length;
					})
			},
			AddData() {
				let that = this;
				that.$axios.post('http://localhost:8081/AddOneTeacher', that.form).then(res => {
					console.log(res.data);
					alert(res.data);
				})
			},
			queryDataByKey() {
				console.log(this.key);
				let that = this;
				this.$axios.get('http://localhost:8081/GetTeachersByKey/' + this.key)
					.then(res => {
						console.log(res.data);
						if (this.key == null) {
							alert('请输关键词!')
						};
						this.dialogQurey = true;
						this.Types = res.data;

					})
			},
			getHospital() {
				let that = this;
				this.$axios.get('/Hospital/GetAll').then(res => {
					let data = {};
					for (var index in res.data.response) {
						let item = res.data.response[index];
						data[item.Id] = item;
					}
					that.Types = data;
				})
			},
			beforeAvatarUpload(file) {
				const isLt10M = file.size / 1024 / 1024 < 10;

				if (!isLt10M) {
					this.$message.error('上传头像图片只能是 JPG 格式!');
				}
				return isLt10M;
			},
			handleSizeChange(val) {
				this.pageSize = val;
				this.getTableData();
			},
			handleCurrentChange(val) {
				this.currentPage = val;
				this.getTableData();
			},
		}
	}
</script>



<style scoped>
	el-image__error,
	el-image__inner,
	el-image__placeholder {
		width: 100%;
		height: 100%;
	}
</style>
