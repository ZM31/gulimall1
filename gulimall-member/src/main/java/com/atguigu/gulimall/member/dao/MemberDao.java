package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ch
 * @email sun@gmail.com
 * @date 2022-05-16 14:02:05
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
