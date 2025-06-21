package com.dao;

import com.entity.DiscusssutuohuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusssutuohuodongVO;
import com.entity.view.DiscusssutuohuodongView;


/**
 * 活动发布评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-24 11:21:30
 */
public interface DiscusssutuohuodongDao extends BaseMapper<DiscusssutuohuodongEntity> {
	
	List<DiscusssutuohuodongVO> selectListVO(@Param("ew") Wrapper<DiscusssutuohuodongEntity> wrapper);
	
	DiscusssutuohuodongVO selectVO(@Param("ew") Wrapper<DiscusssutuohuodongEntity> wrapper);
	
	List<DiscusssutuohuodongView> selectListView(@Param("ew") Wrapper<DiscusssutuohuodongEntity> wrapper);

	List<DiscusssutuohuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssutuohuodongEntity> wrapper);

	
	DiscusssutuohuodongView selectView(@Param("ew") Wrapper<DiscusssutuohuodongEntity> wrapper);
	

}
