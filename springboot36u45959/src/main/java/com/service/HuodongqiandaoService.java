package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongqiandaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongqiandaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongqiandaoView;


/**
 * 签到人员
 *
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface HuodongqiandaoService extends IService<HuodongqiandaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongqiandaoVO> selectListVO(Wrapper<HuodongqiandaoEntity> wrapper);
   	
   	HuodongqiandaoVO selectVO(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
   	
   	List<HuodongqiandaoView> selectListView(Wrapper<HuodongqiandaoEntity> wrapper);
   	
   	HuodongqiandaoView selectView(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongqiandaoEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<HuodongqiandaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<HuodongqiandaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<HuodongqiandaoEntity> wrapper);



}

