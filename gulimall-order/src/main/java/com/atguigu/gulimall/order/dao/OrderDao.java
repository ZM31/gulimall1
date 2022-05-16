package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ch
 * @email sun@gmail.com
 * @date 2022-05-16 13:35:00
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
