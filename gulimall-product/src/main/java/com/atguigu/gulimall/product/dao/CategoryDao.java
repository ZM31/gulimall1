package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ch
 * @email sun@gmail.com
 * @date 2022-05-16 11:26:16
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
