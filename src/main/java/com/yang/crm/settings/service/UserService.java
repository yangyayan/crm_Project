package com.yang.crm.settings.service;

import com.yang.crm.settings.domain.User;

import java.util.Map;

public interface UserService {
    User queryUserByLoginActAndPwd(Map<String,Object> map);
}