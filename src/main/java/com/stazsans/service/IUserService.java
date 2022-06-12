package com.stazsans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stazsans.domain.User;

/**
 * 用户表的service接口
 * @author ss
 */
public interface IUserService extends IService<User> {
    /**
     * 根据用户名查询用户对象
     */
    public User queryUserByUsername(User user);
}
