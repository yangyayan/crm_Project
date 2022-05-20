package com.yang.crm.settings.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("settings/qx/user/")
public class UserController {
    @RequestMapping("toLogin")
    public String toLogin(){
        return "settings/qx/user/login";
    }
}
