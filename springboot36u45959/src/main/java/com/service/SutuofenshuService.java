package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SutuofenshuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SutuofenshuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SutuofenshuView;


/**
 * 积分修改
 *
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface SutuofenshuService extends IService<SutuofenshuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SutuofenshuVO> selectListVO(Wrapper<SutuofenshuEntity> wrapper);
   	
   	SutuofenshuVO selectVO(@Param("ew") Wrapper<SutuofenshuEntity> wrapper);
   	
   	List<SutuofenshuView> selectListView(Wrapper<SutuofenshuEntity> wrapper);
   	
   	SutuofenshuView selectView(@Param("ew") Wrapper<SutuofenshuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SutuofenshuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<SutuofenshuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<SutuofenshuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<SutuofenshuEntity> wrapper);



}

