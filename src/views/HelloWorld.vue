<template>
	<div id="MainBox">
		<!-- 登录界面 -->
		<!-- <el-dialog title="登录" :visible.sync="dialog" width="70%" :before-close="handleCloseTwo">
			<el-form ref="form" :model="form" label-width="100px">
				<el-form-item label="用户名">
					<el-input v-model="form.username"></el-input>
				</el-form-item>
				<el-form-item label="密码">
					<el-input v-model="form.password"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				 <el-button @click="dialog = false">取 消</el-button>
				 <el-button type="primary" @click="submit">确 定</el-button>
			</span>
		</el-dialog> -->

		<!-- <div id="login">
			<router-link to="/Department"></router-link>
		</div> -->
		<div id="LeftBox">
			<div id="LeftTitleBox">
				<span v-if="isCollapse">usst</span>
				<span v-else>usst</span>
			</div>

			<!-- 主界面 -->
			<el-menu style="height:calc( 100% - 50px)" default-active="1-4-1" class="el-menu-vertical-demo"
				@select="selsetCall" :collapse="isCollapse">
				<router-link class="link" to="/RegisterRecord">
					<el-menu-item index="1" select="1">
						<!-- <router-link class="link" to="/RegisterRecord"> -->
						<i class="el-icon-menu"></i>
						<span slot="title">学生信息管理</span>
						<!-- </router-link> -->
					</el-menu-item>
				</router-link>

				<router-link class="link" @click.native="logins" to="/Doctor">
					<el-menu-item index="2" select="2">
						<!-- <router-link class="link" to="/Doctor" disabled="false"> -->
						<i class="el-icon-menu"></i>
						<span slot="title">老师信息管理</span>
						<!-- </router-link> -->
					</el-menu-item>
				</router-link>

				<router-link class="link" to="/Department">
					<el-menu-item index="3" select="3">
						<i class="el-icon-menu"></i>
						<span slot="title">登录页</span>
					</el-menu-item>
				</router-link>

				<!-- <router-link class="link" to="/Department">
					<el-menu-item index="3">
						<i class="el-icon-menu"></i>
						<span slot="title">科室信息管理</span>
					</el-menu-item>
				</router-link> -->

				<router-link class="link" @click.native="logins" to="/Hospital">
					<el-menu-item index="4" select="4">
						<i class="el-icon-menu"></i>
						<span slot="title">用户信息管理</span>
					</el-menu-item>
				</router-link>

			</el-menu>

		</div>
		<div id="RightBox" :style="isCollapse ? 'width: calc(100% - 70px);' : 'width: calc(100% - 210px);' "
			hidden="hidden">
			<div id="RightTitleBox">
				<div id="CollapseBtn" @click="changeCollapse">
					<i v-if="!isCollapse" class="el-icon-s-fold"></i>
					<i v-else class="el-icon-s-unfold"></i>
				</div>
				<div>
					<div id="TitleTextBox">
						<span>线上学校管理系统</span>
					</div>
				</div>
			</div>
			<div id="RightContextBox">
				<router-view />
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: 'HelloWorld',
		data() {
			return {
				isCollapse: true,
				disable: true,
				logindis: false,
				dialog: true,
				pagehidden: false,
				form: {
					username: '',
					password: ''
				}
			};
		},
		mounted() {
			//this.close();
		},
		methods: {
			selsetCall(index, indexPath) {
				console.log(this.$apis)
				if (index == 5) {
					alert("禁止使用")
				}
				document.onmousedown = this.clicks()
				console.log(indexPath)
			},
			logins() {
				if(this.pagehidden == true){
					this.$message.error("请登录！");
					return;
				}
				this.$route.push('/Department')
			},
			clicks() {
				if (index == 1) {
					alert("禁止使用")
				}
			},
			changeCollapse() {
				this.isCollapse = !this.isCollapse;
			},
			submit() {
				if (this.form.username == 'user' && this.form.password == '123456') {
					document.getElementById("LeftBox").removeAttribute('hidden');
					this.pagehidden = false;
					this.dialog = false;
				}
			},
			close() {
				document.getElementById("LeftBox").style.visibility = 'hidden';
				//var d = document.getElementById("RightBox");
				//d.setAttribute("hidden",true);
			}
		}
	}
</script>

<style>
	.el-menu-vertical-demo:not(.el-menu--collapse) {
		width: 200px;
		height: 100%;
	}

	#LeftBox,
	#RightBox {
		display: inline-block;
		vertical-align: top;
	}

	html {
		height: 99%;

	}

	body {
		height: 100%;
		margin: 0;
		font-size: 0;
	}

	h1 {
		font-size: 20px;
	}

	#MainBox {
		height: 100%;
	}

	#LeftBox {
		height: 100%;
		border-right: solid 1px #e6e6e6;
	}

	.link {
		text-decoration: none;
	}

	#LeftBox #LeftTitleBox span {
		font-size: 30px;
		width: 100%;
		display: block;
		text-align: center;
		margin-top: 10px;
	}

	#RightBox #CollapseBtn {
		font-size: 30px;
		margin: 10px 20px;
		display: inline-block;
	}

	#RightBox #RightTitleBox {
		border-bottom: solid 1px #e6e6e6;
	}

	#RightBox #RightTitleBox #TitleTextBox {
		display: inline-block;
		font-size: 25px;
	}
</style>
