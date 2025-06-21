package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XiaoyuanzixunEntity;
import com.entity.view.XiaoyuanzixunView;

import com.service.XiaoyuanzixunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 校园资讯
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
@RestController
@RequestMapping("/xiaoyuanzixun")
public class XiaoyuanzixunController {
    @Autowired
    private XiaoyuanzixunService xiaoyuanzixunService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoyuanzixunEntity xiaoyuanzixun,
		HttpServletRequest request){
        EntityWrapper<XiaoyuanzixunEntity> ew = new EntityWrapper<XiaoyuanzixunEntity>();

		PageUtils page = xiaoyuanzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoyuanzixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoyuanzixunEntity xiaoyuanzixun, 
		HttpServletRequest request){
        EntityWrapper<XiaoyuanzixunEntity> ew = new EntityWrapper<XiaoyuanzixunEntity>();

		PageUtils page = xiaoyuanzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoyuanzixun), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoyuanzixunEntity xiaoyuanzixun){
       	EntityWrapper<XiaoyuanzixunEntity> ew = new EntityWrapper<XiaoyuanzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoyuanzixun, "xiaoyuanzixun")); 
        return R.ok().put("data", xiaoyuanzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoyuanzixunEntity xiaoyuanzixun){
        EntityWrapper< XiaoyuanzixunEntity> ew = new EntityWrapper< XiaoyuanzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoyuanzixun, "xiaoyuanzixun")); 
		XiaoyuanzixunView xiaoyuanzixunView =  xiaoyuanzixunService.selectView(ew);
		return R.ok("查询校园资讯成功").put("data", xiaoyuanzixunView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoyuanzixunEntity xiaoyuanzixun = xiaoyuanzixunService.selectById(id);
        return R.ok().put("data", xiaoyuanzixun);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoyuanzixunEntity xiaoyuanzixun = xiaoyuanzixunService.selectById(id);
        return R.ok().put("data", xiaoyuanzixun);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoyuanzixunEntity xiaoyuanzixun, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoyuanzixun);
        xiaoyuanzixunService.insert(xiaoyuanzixun);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoyuanzixunEntity xiaoyuanzixun, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoyuanzixun);
        xiaoyuanzixunService.insert(xiaoyuanzixun);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoyuanzixunEntity xiaoyuanzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoyuanzixun);
        xiaoyuanzixunService.updateById(xiaoyuanzixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoyuanzixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
