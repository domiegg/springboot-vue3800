<template>
	<div class="addEdit-block" :style='{"padding":"30px"}'>
		<el-form
			:style='{"borderRadius":"6px","padding":"30px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="活动编号" prop="huodongbianhao">
					<el-input v-model="ruleForm.huodongbianhao" placeholder="活动编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.huodongbianhao" label="活动编号" prop="huodongbianhao">
					<el-input v-model="ruleForm.huodongbianhao" placeholder="活动编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动名称" prop="huodongmingcheng">
					<el-input v-model="ruleForm.huodongmingcheng" placeholder="活动名称" clearable  :readonly="ro.huodongmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动名称" prop="huodongmingcheng">
					<el-input v-model="ruleForm.huodongmingcheng" placeholder="活动名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian">
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian">
					<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="活动类型" prop="huodongleixing">
					<el-select :disabled="ro.huodongleixing" v-model="ruleForm.huodongleixing" placeholder="请选择活动类型" >
						<el-option
							v-for="(item,index) in huodongleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动类型" prop="huodongleixing">
					<el-input v-model="ruleForm.huodongleixing"
						placeholder="活动类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="积分" prop="jifen">
					<el-input v-model.number="ruleForm.jifen" placeholder="积分" clearable  :readonly="ro.jifen"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="积分" prop="jifen">
					<el-input v-model="ruleForm.jifen" placeholder="积分" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="活动状态" prop="huodongzhuangtai">
					<el-select :disabled="ro.huodongzhuangtai" v-model="ruleForm.huodongzhuangtai" placeholder="请选择活动状态" >
						<el-option
							v-for="(item,index) in huodongzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动状态" prop="huodongzhuangtai">
					<el-input v-model="ruleForm.huodongzhuangtai"
						placeholder="活动状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="剩余名额" prop="renshu">
					<el-input v-model.number="ruleForm.renshu" placeholder="剩余名额" clearable  :readonly="ro.renshu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="剩余名额" prop="renshu">
					<el-input v-model="ruleForm.renshu" placeholder="剩余名额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="活动日期" prop="huodongriqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.huodongriqi" 
						type="date"
						:readonly="ro.huodongriqi"
						placeholder="活动日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.huodongriqi" label="活动日期" prop="huodongriqi">
					<el-input v-model="ruleForm.huodongriqi" placeholder="活动日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="活动地点" prop="huodongdidian">
					<el-input v-model="ruleForm.huodongdidian" placeholder="活动地点" clearable  :readonly="ro.huodongdidian"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="活动地点" prop="huodongdidian">
					<el-input v-model="ruleForm.huodongdidian" placeholder="活动地点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="发布时间" prop="fabushijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.fabushijian" 
						type="date"
						:readonly="ro.fabushijian"
						placeholder="发布时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
					<el-input v-model="ruleForm.fabushijian" placeholder="发布时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="教师工号" prop="jiaoshigonghao">
					<el-input v-model="ruleForm.jiaoshigonghao" placeholder="教师工号" clearable  :readonly="ro.jiaoshigonghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="教师工号" prop="jiaoshigonghao">
					<el-input v-model="ruleForm.jiaoshigonghao" placeholder="教师工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="教师姓名" prop="jiaoshixingming">
					<el-input v-model="ruleForm.jiaoshixingming" placeholder="教师姓名" clearable  :readonly="ro.jiaoshixingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="教师姓名" prop="jiaoshixingming">
					<el-input v-model="ruleForm.jiaoshixingming" placeholder="教师姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="地址" prop="fulladdress">
					<el-input @click.native="openMapDiolag"  v-model="ruleForm.fulladdress" placeholder="请选择地址"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.fulladdress" label="地址" prop="fulladdress">
					<el-input v-model="ruleForm.fulladdress" placeholder="请选择地址" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    
    <el-dialog
      width="50%"
      title="坐标查询"
      :visible.sync="mapVisiable"
      append-to-body>
      <el-amap-search-box class="search-box" :on-search-result="onSearchResult" :search-option="searchOption" ></el-amap-search-box>
      <div class="amap-wrapper">
        <el-amap class="amap-box" :vid="'amap-vue'" 
        :center="center"
        :zoom="zoom"
        :plugin="plugin"
        :events="events" >
          <el-amap-marker v-bind:key="marker" v-for="marker in markers" :position="marker" ></el-amap-marker>
        </el-amap>
      </div>
      <div>坐标：[{{ ruleForm.longitude }}, {{ ruleForm.latitude }}],地址：{{ruleForm.fulladdress}}</div>
    </el-dialog>

  </div>
</template>
<script>
import { 
	isNumber,
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				huodongbianhao : false,
				huodongmingcheng : false,
				tupian : false,
				huodongleixing : false,
				jifen : false,
				huodongzhuangtai : false,
				renshu : false,
				huodongriqi : false,
				huodongdidian : false,
				fabushijian : false,
				jiaoshigonghao : false,
				jiaoshixingming : false,
				thumbsupnum : false,
				crazilynum : false,
				clicktime : false,
				clicknum : false,
				discussnum : false,
				storeupnum : false,
				longitude : false,
				latitude : false,
				fulladdress : false,
			},
			
			// 地图
			mapVisiable: false,
			zoom: 12,
			center: [116.410426, 39.934946],
			markers: [],
			searchOption: {
				citylimit: false
			},
            plugin: [{
                // 定位城市
                pName: "CitySearch",
                events: {
                    init(o) {
                        // o是高德地图定位插件实例
                        o.getLocalCity(function(status, result) {
                            if (status === "complete" && result.info === "OK") {
                                // 查询成功，result即为当前所在城市信息
                                self.center = [result.rectangle.split(';')[0].split(',')[0], result.rectangle.split(';')[0].split(',')[1]];
                            }
                        });
                    }
                }
            }, ],
			events: {
				click (e) {
					let { lng, lat } = e.lnglat
					self.ruleForm.longitude = lng
					self.ruleForm.latitude = lat
					// 这里通过高德 SDK 完成。
					/* eslint-disable */
					var geocoder = new AMap.Geocoder({
						radius: 1000,
						extensions: 'all'
					})
					geocoder.getAddress([lng, lat], function (status, result) {
						if (status === 'complete' && result.info === 'OK') {
							if (result && result.regeocode) {
                                self.mapVisiable = false
								self.ruleForm.fulladdress = result.regeocode.formattedAddress
							}
						}
					})
				}
			},
			
			ruleForm: {
				huodongbianhao: this.getUUID(),
				huodongmingcheng: '',
				tupian: '',
				huodongleixing: '',
				jifen: '',
				huodongzhuangtai: '',
				renshu: '',
				huodongriqi: '',
				huodongdidian: '',
				fabushijian: '',
				jiaoshigonghao: '',
				jiaoshixingming: '',
				clicktime: '',
				longitude: '',
				latitude: '',
				fulladdress: '',
			},
		
			huodongleixingOptions: [],
			huodongzhuangtaiOptions: [],

			
			rules: {
				huodongbianhao: [
				],
				huodongmingcheng: [
				],
				tupian: [
				],
				huodongleixing: [
				],
				jifen: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				huodongzhuangtai: [
				],
				renshu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				huodongriqi: [
				],
				huodongdidian: [
				],
				fabushijian: [
				],
				jiaoshigonghao: [
				],
				jiaoshixingming: [
				],
				thumbsupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				crazilynum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				clicktime: [
				],
				clicknum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				discussnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				storeupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				longitude: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				latitude: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				fulladdress: [
				],
			},
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.fabushijian = this.getCurDate()
	},
	methods: {
		// 打开坐标定位窗口
		openMapDiolag () {
			this.mapVisiable = true
		},
		// 查询
		onSearchResult (pois) {
			let latSum = 0;
			let lngSum = 0;
			if (pois.length > 0) {
				pois.forEach(poi => {
					let {lng, lat} = poi;
					lngSum += lng;
					latSum += lat;
					this.markers.push([poi.lng, poi.lat]);
				});
				let center = {
					lng: lngSum / pois.length,
					lat: latSum / pois.length
				};
				this.center = [center.lng, center.lat];
			}
		},
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='huodongbianhao'){
							this.ruleForm.huodongbianhao = obj[o];
							this.ro.huodongbianhao = true;
							continue;
						}
						if(o=='huodongmingcheng'){
							this.ruleForm.huodongmingcheng = obj[o];
							this.ro.huodongmingcheng = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
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
						if(o=='huodongzhuangtai'){
							this.ruleForm.huodongzhuangtai = obj[o];
							this.ro.huodongzhuangtai = true;
							continue;
						}
						if(o=='renshu'){
							this.ruleForm.renshu = obj[o];
							this.ro.renshu = true;
							continue;
						}
						if(o=='huodongriqi'){
							this.ruleForm.huodongriqi = obj[o];
							this.ro.huodongriqi = true;
							continue;
						}
						if(o=='huodongdidian'){
							this.ruleForm.huodongdidian = obj[o];
							this.ro.huodongdidian = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
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
						if(o=='thumbsupnum'){
							this.ruleForm.thumbsupnum = obj[o];
							this.ro.thumbsupnum = true;
							continue;
						}
						if(o=='crazilynum'){
							this.ruleForm.crazilynum = obj[o];
							this.ro.crazilynum = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='clicknum'){
							this.ruleForm.clicknum = obj[o];
							this.ro.clicknum = true;
							continue;
						}
						if(o=='discussnum'){
							this.ruleForm.discussnum = obj[o];
							this.ro.discussnum = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
						if(o=='longitude'){
							this.ruleForm.longitude = obj[o];
							this.ro.longitude = true;
							continue;
						}
						if(o=='latitude'){
							this.ruleForm.latitude = obj[o];
							this.ro.latitude = true;
							continue;
						}
						if(o=='fulladdress'){
							this.ruleForm.fulladdress = obj[o];
							this.ro.fulladdress = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(((json.jiaoshigonghao!=''&&json.jiaoshigonghao) || json.jiaoshigonghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.jiaoshigonghao = json.jiaoshigonghao
						this.ro.jiaoshigonghao = true;
					}
					if(((json.jiaoshixingming!=''&&json.jiaoshixingming) || json.jiaoshixingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.jiaoshixingming = json.jiaoshixingming
						this.ro.jiaoshixingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
            this.$http({
				url: `option/huodongleixing/huodongleixing`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.huodongleixingOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.huodongzhuangtaiOptions = "报名中,已截止".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `sutuohuodong/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
		if(this.ruleForm.huodongbianhao) {
			this.ruleForm.huodongbianhao = String(this.ruleForm.huodongbianhao)
		}
	if(this.ruleForm.tupian!=null) {
		this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "sutuohuodong/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `sutuohuodong/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.sutuohuodongCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `sutuohuodong/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.sutuohuodongCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
		});
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.sutuohuodongCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    tupianUploadChange(fileUrls) {
	    this.ruleForm.tupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  white-space: nowrap;
	  	  font-weight: 500;
	  	  width: 180px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px dashed #385d86;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #385d86;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px dashed #385d86;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #385d86;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px dashed #385d86;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #385d86;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #385d86;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #385d86;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #385d86;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #385d86;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #385d86;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
