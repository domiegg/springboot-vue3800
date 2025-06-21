package com.dao;

import com.entity.HuodongqiandaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongqiandaoVO;
import com.entity.view.HuodongqiandaoView;


/**
 * 签到人员
 * 
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface HuodongqiandaoDao extends BaseMapper<HuodongqiandaoEntity> {
	
	List<HuodongqiandaoVO> selectListVO(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
	
	HuodongqiandaoVO selectVO(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
	
	List<HuodongqiandaoView> selectListView(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);

	List<HuodongqiandaoView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);

	
	HuodongqiandaoView selectView(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);



}
