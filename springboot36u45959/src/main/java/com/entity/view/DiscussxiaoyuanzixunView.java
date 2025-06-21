package com.entity.view;

import com.entity.DiscussxiaoyuanzixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 校园资讯评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-24 11:21:30
 */
@TableName("discussxiaoyuanzixun")
public class DiscussxiaoyuanzixunView  extends DiscussxiaoyuanzixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxiaoyuanzixunView(){
	}
 
 	public DiscussxiaoyuanzixunView(DiscussxiaoyuanzixunEntity discussxiaoyuanzixunEntity){
 	try {
			BeanUtils.copyProperties(this, discussxiaoyuanzixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
