package com.yang.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/workbench/main/")
@Controller
public class MainController {
    @RequestMapping("toIndex")
    public String index(){
        return "workbench/main/index";
    }
}
