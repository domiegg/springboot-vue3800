<template>
<view class="content">
	<view class="box" :style='{"padding":"80rpx 0 0 0","backgroundColor":"#fff","backgroundImage":"url(http://codegen.caihongy.cn/20231129/e8410bdf8b224d6fb345eb65254a74e8.png)","width":"100%","backgroundSize":"100% 100%","position":"relative","height":"100%"}'>
		<view :style='{"width":"100%","padding":"24rpx 100rpx","display":"block","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">教师工号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.jiaoshigonghao"  type="text"  class="uni-input" name="" placeholder="教师工号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">教师姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.jiaoshixingming"  type="text"  class="uni-input" name="" placeholder="教师姓名" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" class="">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0 0 24rpx 0","flexWrap":"wrap","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'"  @change="jiaoshixingbieChange" :value="jiaoshixingbieIndex" :range="jiaoshixingbieOptions">
					<view>
						<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#D4CF5D"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" @tap="jiaoshitouxiangTap" class="">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">头像：</view>
				<image :style='{"width":"80rpx","borderRadius":"16rpx","background":"#F6F6F4","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"80rpx","borderRadius":"16rpx","background":"#F6F6F4","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">电话号码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.dianhuahaoma"  type="text"  class="uni-input" name="" placeholder="电话号码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='jiaoshi'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">职称：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.zhicheng"  type="text"  class="uni-input" name="" placeholder="职称" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">学生账号：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.xueshengzhanghao"  type="text"  class="uni-input" name="" placeholder="学生账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">学生姓名：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.xueshengxingming"  type="text"  class="uni-input" name="" placeholder="学生姓名" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0 0 24rpx 0","flexWrap":"wrap","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'"  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
					<view>
						<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#D4CF5D"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengtouxiangTap" class="">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">头像：</view>
				<image :style='{"width":"80rpx","borderRadius":"16rpx","background":"#F6F6F4","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"80rpx","borderRadius":"16rpx","background":"#F6F6F4","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">电话号码：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.dianhuahaoma"  type="text"  class="uni-input" name="" placeholder="电话号码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","flexDirection":"column","display":"flex","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#000000","textAlign":"left"}' class="label">班级：</view>
				<input :style='{"border":"0px solid rgb(255, 170, 51)","padding":"20rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"0","flex":"1","background":"#F6F6F4","fontSize":"28rpx","lineHeight":"88rpx"}'  v-model="ruleForm.banji"  type="text"  class="uni-input" name="" placeholder="班级" />
			</view>
			<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#D4CF5D","width":"100%","lineHeight":"88rpx","fontSize":"48rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"color":"#000000","top":"40rpx","display":"none","width":"100%","fontSize":"72rpx","position":"absolute","height":"80rpx"}'>欢迎注册</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                jiaoshixingbieOptions: [],
                jiaoshixingbieIndex: 0,
                xueshengxingbieOptions: [],
                xueshengxingbieIndex: 0,
				ruleForm: {
                jiaoshigonghao: '',
                jiaoshixingming: '',
                mima: '',
                xingbie: '',
                touxiang: '',
                dianhuahaoma: '',
                zhicheng: '',
                xueshengzhanghao: '',
                xueshengxingming: '',
                mima: '',
                xingbie: '',
                touxiang: '',
                dianhuahaoma: '',
                banji: '',
                jifen: '0',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='jiaoshi'){
                this.jiaoshixingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.jiaoshixingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='xuesheng'){
                this.xueshengxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.xueshengxingbieOptions[0]
			}
            if(`xuesheng` == this.tableName){
                this.ruleForm.jifen='0'
            }
			
			this.styleChange()
		},
		methods: {

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
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
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
                if(`jiaoshi` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
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
                if(`xuesheng` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
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
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
