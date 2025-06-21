package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SutuohuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SutuohuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SutuohuodongView;


/**
 * 活动发布
 *
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface SutuohuodongService extends IService<SutuohuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SutuohuodongVO> selectListVO(Wrapper<SutuohuodongEntity> wrapper);
   	
   	SutuohuodongVO selectVO(@Param("ew") Wrapper<SutuohuodongEntity> wrapper);
   	
   	List<SutuohuodongView> selectListView(Wrapper<SutuohuodongEntity> wrapper);
   	
   	SutuohuodongView selectView(@Param("ew") Wrapper<SutuohuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SutuohuodongEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<SutuohuodongEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<SutuohuodongEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<SutuohuodongEntity> wrapper);



}

