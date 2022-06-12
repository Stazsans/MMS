package com.stazsans.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stazsans.dao.UserMapper;
import com.stazsans.domain.User;
import com.stazsans.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 * @author ss
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户名查询用户对象
     *
     * @param user
     */
    @Override
    public User queryUserByUsername(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        return userMapper.selectOne(wrapper);
    }
}
