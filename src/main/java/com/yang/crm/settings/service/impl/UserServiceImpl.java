package com.yang.crm.settings.service.impl;

import com.yang.crm.settings.domain.User;
import com.yang.crm.settings.mapper.UserMapper;
import com.yang.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserByLoginActAndPwd(Map<String, Object> map) {
        User user = userMapper.selectUserLoginActAndPwd(map);
        return user;
    }
}
