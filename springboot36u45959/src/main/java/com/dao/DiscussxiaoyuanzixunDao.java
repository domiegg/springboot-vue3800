package com.dao;

import com.entity.DiscussxiaoyuanzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxiaoyuanzixunVO;
import com.entity.view.DiscussxiaoyuanzixunView;


/**
 * 校园资讯评论表
 * 
 * @author 
 * @email 
 * @date 2024-05-24 11:21:30
 */
public interface DiscussxiaoyuanzixunDao extends BaseMapper<DiscussxiaoyuanzixunEntity> {
	
	List<DiscussxiaoyuanzixunVO> selectListVO(@Param("ew") Wrapper<DiscussxiaoyuanzixunEntity> wrapper);
	
	DiscussxiaoyuanzixunVO selectVO(@Param("ew") Wrapper<DiscussxiaoyuanzixunEntity> wrapper);
	
	List<DiscussxiaoyuanzixunView> selectListView(@Param("ew") Wrapper<DiscussxiaoyuanzixunEntity> wrapper);

	List<DiscussxiaoyuanzixunView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiaoyuanzixunEntity> wrapper);

	
	DiscussxiaoyuanzixunView selectView(@Param("ew") Wrapper<DiscussxiaoyuanzixunEntity> wrapper);
	

}
