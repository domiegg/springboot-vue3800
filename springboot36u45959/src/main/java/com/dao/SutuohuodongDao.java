package com.dao;

import com.entity.SutuohuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SutuohuodongVO;
import com.entity.view.SutuohuodongView;


/**
 * 活动发布
 * 
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface SutuohuodongDao extends BaseMapper<SutuohuodongEntity> {
	
	List<SutuohuodongVO> selectListVO(@Param("ew") Wrapper<SutuohuodongEntity> wrapper);
	
	SutuohuodongVO selectVO(@Param("ew") Wrapper<SutuohuodongEntity> wrapper);
	
	List<SutuohuodongView> selectListView(@Param("ew") Wrapper<SutuohuodongEntity> wrapper);

	List<SutuohuodongView> selectListView(Pagination page,@Param("ew") Wrapper<SutuohuodongEntity> wrapper);

	
	SutuohuodongView selectView(@Param("ew") Wrapper<SutuohuodongEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SutuohuodongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SutuohuodongEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SutuohuodongEntity> wrapper);



}
