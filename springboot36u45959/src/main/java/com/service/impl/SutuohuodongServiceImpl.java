package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SutuohuodongDao;
import com.entity.SutuohuodongEntity;
import com.service.SutuohuodongService;
import com.entity.vo.SutuohuodongVO;
import com.entity.view.SutuohuodongView;

@Service("sutuohuodongService")
public class SutuohuodongServiceImpl extends ServiceImpl<SutuohuodongDao, SutuohuodongEntity> implements SutuohuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SutuohuodongEntity> page = this.selectPage(
                new Query<SutuohuodongEntity>(params).getPage(),
                new EntityWrapper<SutuohuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SutuohuodongEntity> wrapper) {
		  Page<SutuohuodongView> page =new Query<SutuohuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SutuohuodongVO> selectListVO(Wrapper<SutuohuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SutuohuodongVO selectVO(Wrapper<SutuohuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SutuohuodongView> selectListView(Wrapper<SutuohuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SutuohuodongView selectView(Wrapper<SutuohuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<SutuohuodongEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<SutuohuodongEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<SutuohuodongEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
