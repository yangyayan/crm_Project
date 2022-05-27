package com.yang.crm.workbench.web.controller;

import com.yang.crm.settings.domain.User;
import com.yang.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/workbench/activity/")
public class ActivityController {
    @Autowired
    private UserService userService;

    @RequestMapping("toIndex")
    public String toIndex(ModelMap modelMap){
        List<User> userList = userService.queryAllUsers();
        modelMap.addAttribute("userList",userList);
        return "workbench/activity/index";
    }
}
