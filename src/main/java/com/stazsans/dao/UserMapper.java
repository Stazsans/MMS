package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表的增删改查Mapper
 * @author ss
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
