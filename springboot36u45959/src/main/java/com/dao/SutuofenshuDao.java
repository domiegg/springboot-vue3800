package com.dao;

import com.entity.SutuofenshuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SutuofenshuVO;
import com.entity.view.SutuofenshuView;


/**
 * 积分修改
 * 
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface SutuofenshuDao extends BaseMapper<SutuofenshuEntity> {
	
	List<SutuofenshuVO> selectListVO(@Param("ew") Wrapper<SutuofenshuEntity> wrapper);
	
	SutuofenshuVO selectVO(@Param("ew") Wrapper<SutuofenshuEntity> wrapper);
	
	List<SutuofenshuView> selectListView(@Param("ew") Wrapper<SutuofenshuEntity> wrapper);

	List<SutuofenshuView> selectListView(Pagination page,@Param("ew") Wrapper<SutuofenshuEntity> wrapper);

	
	SutuofenshuView selectView(@Param("ew") Wrapper<SutuofenshuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SutuofenshuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SutuofenshuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SutuofenshuEntity> wrapper);



}
