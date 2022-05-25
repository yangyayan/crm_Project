package com.yang.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/workbench/")
public class WorkbenchIndexController {

    @RequestMapping("toIndex")
    public String toIndex(){
        return "/workbench/index";
    }
}
