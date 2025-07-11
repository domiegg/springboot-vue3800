package com.entity.view;

import com.entity.DiscusssutuohuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 活动发布评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-24 11:21:30
 */
@TableName("discusssutuohuodong")
public class DiscusssutuohuodongView  extends DiscusssutuohuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusssutuohuodongView(){
	}
 
 	public DiscusssutuohuodongView(DiscusssutuohuodongEntity discusssutuohuodongEntity){
 	try {
			BeanUtils.copyProperties(this, discusssutuohuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
