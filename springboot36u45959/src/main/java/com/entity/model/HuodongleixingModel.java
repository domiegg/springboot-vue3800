package com.entity.model;

import com.entity.HuodongleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 活动类型
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-05-24 11:21:29
 */
public class HuodongleixingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * image
	 */
	
	private String image;
				
	
	/**
	 * 设置：image
	 */
	 
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * 获取：image
	 */
	public String getImage() {
		return image;
	}
			
}
