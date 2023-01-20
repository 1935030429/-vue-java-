<template>
	<div id="MainBox">
		<div id="ButtonBox">
			<el-input class="QueryInput" v-model="key" placeholder="请输入关键词"></el-input>
			<el-button class="button" size="medium" plain @click="queryDataByKey">检索</el-button>
			<el-button class="button" size="medium" type="primary" plain>添加</el-button>
			<el-button class="button" size="medium" type="success" plain>修改</el-button>
			<el-button class="button" size="medium" type="danger" plain>删除</el-button>
		</div>
		<div id="TableBox">
			<el-table :data="tableData" @selection-change="handleSelectionChange" style="width: 100%;" height="800px" header-align="center" :row-style="{height: '30px'}">
				<el-table-column prop="id" label="序号" width="180" show-overflow-tooltip>
				</el-table-column>
				<el-table-column prop="username" label="姓名" width="180" show-overflow-tooltip>
				</el-table-column>
				<el-table-column prop="password" label="密码" width="180" show-overflow-tooltip>
					<template slot-scope="scope">
						<el-tag size="medium">{{ scope.row.password }}</el-tag>
					</template>
				</el-table-column>
				<!-- <el-table-column
              prop="Image"
               label="图片" height:20px>
               <el-image :src=" 'https://bmeit.cn/base_api' + Image " stlye="height:200px;"></el-image>
            </el-table-column> -->
				<!-- <el-table-column prop="Description" label="描述">
				</el-table-column>
				<el-table-column prop="Type" label="类型" width="180">
					<template slot-scope="scope">
						<el-tag size="medium">{{ Types[scope.row.Type].Type }}</el-tag>
					</template>
				</el-table-column> -->
			</el-table>
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="pageSize"
				layout="total, sizes, prev, pager, next, jumper" :total="total">
			</el-pagination>
		</div>

		<!-- 添加信息对话框 -->


		<!-- 修改信息对话框 -->

	</div>
</template>

<script>
	export default {
		name: 'Hospital',
		data() {
			return {
				tableData: [
					// id:'',
					// name:'',
					// password:''
				],
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
			}
		},
		mounted() {
			this.getTableData();
			this.getHospital();
		},
		methods: {
			handleSelectionChange(val) {
				this.multipleSelection = val;
			},
			getTableData() {
				let that = this;
				this.$axios.get('http://localhost:8081/getAllUser')
					.then(res => {
						console.log(res.data.response);
						that.tableData = res.data;

					})
			},
			queryDataByKey() {
				console.log(this.key);
				let that = this;
				this.$axios.get('' + this.currentPage +
						'&intPageSize=' + this.pageSize)
					.then(res => {
						console.log(res.data.response);
						this.tableData = res.data.response.data;

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
	#ButtonBox {
		margin: 10px 20px;
	}

	.QueryInput {
		width: 200px;
		margin-right: 10px;
	}

	.el-table td,
	.el-table th {
		height: 40px;
	}

	.el-image__error,
	.el-image__inner,
	.el-image__placeholder {
		height: 20px;
	}
</style>
