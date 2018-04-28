package com.xdchen.order.service.impl;

import com.xdchen.order.dao.TbUserMapper;
import com.xdchen.order.model.TbUser;
import com.xdchen.order.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final TbUserMapper userMapper;

    @Autowired
    public UserService(TbUserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public void addUser(TbUser user) {
        userMapper.add(user);
    }

    @Override
    public TbUser findUserById(Long userId) {
        return userMapper.findUser(userId);
    }

    @Override
    public List<TbUser> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public List<TbUser> findIncrementUsers(Long limit) {
        return userMapper.findIncrementUsers(limit);
    }

    @Override
    public void updateAuthorizeInfo(TbUser user) {
        userMapper.updateAuthorizeInfo(user);
    }

    @Override
    public void updateLastUpdateTime(Long userId, Date lastUpdateTime) {
        userMapper.updateLastUpdateTime(userId, lastUpdateTime);
    }
}
