package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author ch
 * @email sun@gmail.com
 * @date 2022-05-16 13:09:10
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
