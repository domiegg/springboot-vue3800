package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusssutuohuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusssutuohuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusssutuohuodongView;


/**
 * 活动发布评论表
 *
 * @author 
 * @email 
 * @date 2024-05-24 11:21:30
 */
public interface DiscusssutuohuodongService extends IService<DiscusssutuohuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssutuohuodongVO> selectListVO(Wrapper<DiscusssutuohuodongEntity> wrapper);
   	
   	DiscusssutuohuodongVO selectVO(@Param("ew") Wrapper<DiscusssutuohuodongEntity> wrapper);
   	
   	List<DiscusssutuohuodongView> selectListView(Wrapper<DiscusssutuohuodongEntity> wrapper);
   	
   	DiscusssutuohuodongView selectView(@Param("ew") Wrapper<DiscusssutuohuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssutuohuodongEntity> wrapper);

   	

}

