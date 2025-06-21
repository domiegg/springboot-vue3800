package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianbaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianbaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianbaomingView;


/**
 * 报名管理
 *
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface ZaixianbaomingService extends IService<ZaixianbaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianbaomingVO> selectListVO(Wrapper<ZaixianbaomingEntity> wrapper);
   	
   	ZaixianbaomingVO selectVO(@Param("ew") Wrapper<ZaixianbaomingEntity> wrapper);
   	
   	List<ZaixianbaomingView> selectListView(Wrapper<ZaixianbaomingEntity> wrapper);
   	
   	ZaixianbaomingView selectView(@Param("ew") Wrapper<ZaixianbaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianbaomingEntity> wrapper);

   	

}

