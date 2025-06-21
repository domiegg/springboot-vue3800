package com.dao;

import com.entity.ZaixianbaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianbaomingVO;
import com.entity.view.ZaixianbaomingView;


/**
 * 报名管理
 * 
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public interface ZaixianbaomingDao extends BaseMapper<ZaixianbaomingEntity> {
	
	List<ZaixianbaomingVO> selectListVO(@Param("ew") Wrapper<ZaixianbaomingEntity> wrapper);
	
	ZaixianbaomingVO selectVO(@Param("ew") Wrapper<ZaixianbaomingEntity> wrapper);
	
	List<ZaixianbaomingView> selectListView(@Param("ew") Wrapper<ZaixianbaomingEntity> wrapper);

	List<ZaixianbaomingView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianbaomingEntity> wrapper);

	
	ZaixianbaomingView selectView(@Param("ew") Wrapper<ZaixianbaomingEntity> wrapper);
	

}
