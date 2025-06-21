<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
		<view :style='{"width":"100%","padding":"24rpx","background":"#fff","display":"block","height":"auto"}'>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>教师工号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.jiaoshigonghao" placeholder="教师工号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>教师姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.jiaoshixingming" placeholder="教师姓名"></input>
			</view>
			<view v-if="tableName=='jiaoshi'" :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="jiaoshixingbieChange" :value="jiaoshixingbieIndex" :range="jiaoshixingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#D4CF5D"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" @tap="jiaoshitouxiangTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>电话号码</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.dianhuahaoma" placeholder="电话号码"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='jiaoshi'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>职称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.zhicheng" placeholder="职称"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>学生账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.xueshengzhanghao" placeholder="学生账号"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>学生姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.xueshengxingming" placeholder="学生姓名"></input>
			</view>
			<view v-if="tableName=='xuesheng'" :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">性别</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}'  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#D4CF5D"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengtouxiangTap" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>头像</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" style="margin: 0;" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>电话号码</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.dianhuahaoma" placeholder="电话号码"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>班级</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'   v-model="ruleForm.banji" placeholder="班级"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view class="title" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>积分</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled="true"  v-model="ruleForm.jifen" placeholder="积分"></input>
			</view>
			<view :style='{"width":"100%","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex","height":"auto"}' class="btn">
				<button @tap="update()" class="cu-btn lg" :style='{"border":"0","padding":"0px","margin":"0 20rpx 20rpx","color":"rgb(255, 255, 255)","background":"#D4CF5D","width":"80%","lineHeight":"80rpx","fontSize":"36rpx","height":"80rpx"}'>保存</button>
				<button @tap="logout()" class="cu-btn lg" :style='{"border":"0","padding":"0px","margin":"0 20rpx","color":"#fff","background":"#B4B4AA","width":"80%","lineHeight":"80rpx","fontSize":"36rpx","height":"80rpx"}'>退出登录</button>
			</view>
		</view>
	</view>
</view>
</template>

<script>

    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				ruleForm: {
				},
				tableName:"",
				jiaoshixingbieOptions: [],
				jiaoshixingbieIndex: 0,
				xueshengxingbieOptions: [],
				xueshengxingbieIndex: 0,
			}
		},
        components: {
            multipleSelect,
			xiaEditor
        },
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let that = this
			let res = {}
			this.tableName = table;
			this.getSession()
			// 自定义下拉框值
			if(this.tableName=='jiaoshi'){
				this.jiaoshixingbieOptions = "男,女".split(',');
				this.jiaoshixingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.jiaoshixingbieIndex = index;
					}
				});
			}
			// 自定义下拉框值
			if(this.tableName=='xuesheng'){
				this.xueshengxingbieOptions = "男,女".split(',');
				this.xueshengxingbieOptions.forEach((item, index) => {
					if(item==this.ruleForm.xingbie) {
						this.xueshengxingbieIndex = index;
					}
				});
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let res = await this.$api.session(this.tableName)
				this.ruleForm = res.data;
				uni.setStorageSync('userSession',JSON.stringify(res.data))
			},
            // 下拉变化
            jiaoshixingbieChange(e) {
                    this.jiaoshixingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.jiaoshixingbieOptions[this.jiaoshixingbieIndex]
            },
			jiaoshitouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
            // 下拉变化
            xueshengxingbieChange(e) {
                    this.xueshengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xueshengxingbieOptions[this.xueshengxingbieIndex]
            },
			xueshengtouxiangTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('. .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			logout() {
				uni.clearStorageSync()
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {

				if((!this.ruleForm.jiaoshigonghao) && `jiaoshi` == this.tableName){
					this.$utils.msg(`教师工号不能为空`);
					return
				}

				if((!this.ruleForm.jiaoshixingming) && `jiaoshi` == this.tableName){
					this.$utils.msg(`教师姓名不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `jiaoshi` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}



				if(`jiaoshi` == this.tableName && this.ruleForm.dianhuahaoma&&(!this.$validate.isMobile(this.ruleForm.dianhuahaoma))){
					this.$utils.msg(`电话号码应输入手机格式`);
					return
				}


				if((!this.ruleForm.xueshengzhanghao) && `xuesheng` == this.tableName){
					this.$utils.msg(`学生账号不能为空`);
					return
				}

				if((!this.ruleForm.xueshengxingming) && `xuesheng` == this.tableName){
					this.$utils.msg(`学生姓名不能为空`);
					return
				}

				if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}



				if(`xuesheng` == this.tableName && this.ruleForm.dianhuahaoma&&(!this.$validate.isMobile(this.ruleForm.dianhuahaoma))){
					this.$utils.msg(`电话号码应输入手机格式`);
					return
				}


				if(`xuesheng` == this.tableName && this.ruleForm.jifen&&(!this.$validate.isIntNumer(this.ruleForm.jifen))){
					this.$utils.msg(`积分应输入整数`);
					return
				}
				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
				this.getSession()
			},

		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
