<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0","position":"relative","background":"#fff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"#fff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">报名编号</view>
				<view :style='{"padding":"0px 24rpx","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}' class="right-input">
					{{ruleForm.baomingbianhao}}
				</view>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">活动名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.huodongmingcheng" v-model="ruleForm.huodongmingcheng" placeholder="活动名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">活动类型</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.huodongleixing" v-model="ruleForm.huodongleixing" placeholder="活动类型"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">积分</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jifen" v-model.number="ruleForm.jifen" placeholder="积分" type="number"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="tupianTap">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">报名时间</view>
				<picker  :disabled="ro.baomingshijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.baomingshijian" @change="baomingshijianChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#D4CF5D"}' class="uni-input">{{ruleForm.baomingshijian?ruleForm.baomingshijian:"请选择报名时间"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">人数</view>
				<picker :disabled="ro.renshu" :style='{"width":"100%","flex":"1","height":"auto"}' @change="renshuChange" :value="renshuIndex" :range="renshuOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#D4CF5D"}' class="uni-input">{{ruleForm.renshu?ruleForm.renshu:"请选择人数"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">学生账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xueshengzhanghao" v-model="ruleForm.xueshengzhanghao" placeholder="学生账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">学生姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xueshengxingming" v-model="ruleForm.xueshengxingming" placeholder="学生姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">班级</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.banji" v-model="ruleForm.banji" placeholder="班级"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">教师工号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jiaoshigonghao" v-model="ruleForm.jiaoshigonghao" placeholder="教师工号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"auto","padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="title">教师姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jiaoshixingming" v-model="ruleForm.jiaoshixingming" placeholder="教师姓名"  type="text"></input>
			</view>
 

			
			<view :style='{"width":"100%","alignItems":"center","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0","color":"rgb(255, 255, 255)","background":"#D4CF5D","width":"48%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				baomingbianhao: this.getUUID(),
				huodongmingcheng: '',
				huodongleixing: '',
				jifen: '',
				tupian: '',
				baomingshijian: '',
				renshu: '',
				xueshengzhanghao: '',
				xueshengxingming: '',
				banji: '',
				jiaoshigonghao: '',
				jiaoshixingming: '',
				shhf: '',
				},
				renshuOptions: [],
				renshuIndex: 0,
				// 登录用户信息
				user: {},
                ro:{
                   baomingbianhao : false,
                   huodongmingcheng : false,
                   huodongleixing : false,
                   jifen : false,
                   tupian : false,
                   baomingshijian : false,
                   renshu : false,
                   xueshengzhanghao : false,
                   xueshengxingming : false,
                   banji : false,
                   jiaoshigonghao : false,
                   jiaoshixingming : false,
                   sfsh : false,
                   shhf : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor,
            multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
            this.ruleForm.baomingshijian = this.$utils.getCurDate();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.xueshengzhanghao = this.user.xueshengzhanghao
			this.ro.xueshengzhanghao = true;
			this.ruleForm.xueshengxingming = this.user.xueshengxingming
			this.ro.xueshengxingming = true;
			this.ruleForm.banji = this.user.banji
			this.ro.banji = true;


			// 自定义下拉框值
			this.renshuOptions = "1".split(',')

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`zaixianbaoming`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='baomingbianhao'){
					this.ruleForm.baomingbianhao = obj[o];
					this.ro.baomingbianhao = true;
					continue;
					}
					if(o=='huodongmingcheng'){
					this.ruleForm.huodongmingcheng = obj[o];
					this.ro.huodongmingcheng = true;
					continue;
					}
					if(o=='huodongleixing'){
					this.ruleForm.huodongleixing = obj[o];
					this.ro.huodongleixing = true;
					continue;
					}
					if(o=='jifen'){
					this.ruleForm.jifen = obj[o];
					this.ro.jifen = true;
					continue;
					}
					if(o=='tupian'){
					this.ruleForm.tupian = obj[o].split(",")[0];
					this.ro.tupian = true;
					continue;
					}
					if(o=='baomingshijian'){
					this.ruleForm.baomingshijian = obj[o];
					this.ro.baomingshijian = true;
					continue;
					}
					if(o=='renshu'){
					this.ruleForm.renshu = obj[o];
					this.ro.renshu = true;
					continue;
					}
					if(o=='xueshengzhanghao'){
					this.ruleForm.xueshengzhanghao = obj[o];
					this.ro.xueshengzhanghao = true;
					continue;
					}
					if(o=='xueshengxingming'){
					this.ruleForm.xueshengxingming = obj[o];
					this.ro.xueshengxingming = true;
					continue;
					}
					if(o=='banji'){
					this.ruleForm.banji = obj[o];
					this.ro.banji = true;
					continue;
					}
					if(o=='jiaoshigonghao'){
					this.ruleForm.jiaoshigonghao = obj[o];
					this.ro.jiaoshigonghao = true;
					continue;
					}
					if(o=='jiaoshixingming'){
					this.ruleForm.jiaoshixingming = obj[o];
					this.ro.jiaoshixingming = true;
					continue;
					}
				}
            this.ruleForm.renshu = 0;
            this.ro.renshu = false;
			}
			this.styleChange()
            this.$forceUpdate()
			
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数

			baomingshijianChange(e) {
				this.ruleForm.baomingshijian = e.target.value;
				this.$forceUpdate();
			},


			// 下拉变化
			renshuChange(e) {
				this.renshuIndex = e.target.value
				this.ruleForm.renshu = this.renshuOptions[this.renshuIndex]
			},

			tupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.tupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				if(this.ruleForm.baomingbianhao){
					this.ruleForm.baomingbianhao = String(this.ruleForm.baomingbianhao)
				}
//跨表计算判断
				var obj;
				obj = uni.getStorageSync('crossObj');
				var table = uni.getStorageSync('crossTable');
				//obj.renshu = obj.renshu - this.ruleForm.renshu
                if((parseFloat(obj.renshu) - parseFloat(this.ruleForm.renshu))<0){
					this.$utils.msg("人数不足");
					return
				}
                if(this.ruleForm.renshu<=0){
					this.$utils.msg("人数不能为0");
					return
				}
				if(this.ruleForm.jifen&&(!this.$validate.isIntNumer(this.ruleForm.jifen))){
					this.$utils.msg(`积分应输入整数`);
					return
				}
				if(this.ruleForm.renshu&&(!this.$validate.isIntNumer(this.ruleForm.renshu))){
					this.$utils.msg(`人数应输入整数`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
                    uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('appUserid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`zaixianbaoming`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
                        if(!obj) {
                            obj = uni.getStorageSync('crossObj');
                        }
                        var table = uni.getStorageSync('crossTable');
                        obj.renshu = parseFloat(obj.renshu) - parseFloat(this.ruleForm.renshu)
                        await this.$api.update(`${table}`, obj);
						if(this.ruleForm.id){
							await this.$api.update(`zaixianbaoming`, this.ruleForm);
						}else{
							await this.$api.add(`zaixianbaoming`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
                    if(!obj) {
                        obj = uni.getStorageSync('crossObj');
                    }
                    var table = uni.getStorageSync('crossTable');
                    obj.renshu = obj.renshu - this.ruleForm.renshu
                    await this.$api.update(`${table}`, obj);
					if(this.ruleForm.id){
						await this.$api.update(`zaixianbaoming`, this.ruleForm);
					}else{
						await this.$api.add(`zaixianbaoming`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
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
