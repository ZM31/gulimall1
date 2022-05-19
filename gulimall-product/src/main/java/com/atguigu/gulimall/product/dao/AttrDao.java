package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author ch
 * @email sun@gmail.com
 * @date 2022-05-16 11:26:16
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
