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


import com.dao.SutuofenshuDao;
import com.entity.SutuofenshuEntity;
import com.service.SutuofenshuService;
import com.entity.vo.SutuofenshuVO;
import com.entity.view.SutuofenshuView;

@Service("sutuofenshuService")
public class SutuofenshuServiceImpl extends ServiceImpl<SutuofenshuDao, SutuofenshuEntity> implements SutuofenshuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SutuofenshuEntity> page = this.selectPage(
                new Query<SutuofenshuEntity>(params).getPage(),
                new EntityWrapper<SutuofenshuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SutuofenshuEntity> wrapper) {
		  Page<SutuofenshuView> page =new Query<SutuofenshuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SutuofenshuVO> selectListVO(Wrapper<SutuofenshuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SutuofenshuVO selectVO(Wrapper<SutuofenshuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SutuofenshuView> selectListView(Wrapper<SutuofenshuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SutuofenshuView selectView(Wrapper<SutuofenshuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<SutuofenshuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<SutuofenshuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<SutuofenshuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
