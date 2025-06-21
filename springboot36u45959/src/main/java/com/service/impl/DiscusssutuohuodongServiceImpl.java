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


import com.dao.DiscusssutuohuodongDao;
import com.entity.DiscusssutuohuodongEntity;
import com.service.DiscusssutuohuodongService;
import com.entity.vo.DiscusssutuohuodongVO;
import com.entity.view.DiscusssutuohuodongView;

@Service("discusssutuohuodongService")
public class DiscusssutuohuodongServiceImpl extends ServiceImpl<DiscusssutuohuodongDao, DiscusssutuohuodongEntity> implements DiscusssutuohuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssutuohuodongEntity> page = this.selectPage(
                new Query<DiscusssutuohuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusssutuohuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssutuohuodongEntity> wrapper) {
		  Page<DiscusssutuohuodongView> page =new Query<DiscusssutuohuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusssutuohuodongVO> selectListVO(Wrapper<DiscusssutuohuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusssutuohuodongVO selectVO(Wrapper<DiscusssutuohuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusssutuohuodongView> selectListView(Wrapper<DiscusssutuohuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssutuohuodongView selectView(Wrapper<DiscusssutuohuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
