package com.yang.crm.workbench.web.controller;

import com.yang.crm.commons.contants.Contants;
import com.yang.crm.commons.dimain.ReturnObject;
import com.yang.crm.commons.utlis.DateUtils;
import com.yang.crm.commons.utlis.UUIDUtils;
import com.yang.crm.settings.domain.User;
import com.yang.crm.settings.service.UserService;
import com.yang.crm.workbench.domain.Activity;
import com.yang.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/workbench/activity/")
public class ActivityController {
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    @RequestMapping("toIndex")
    public String toIndex(ModelMap modelMap){
        List<User> userList = userService.queryAllUsers();
        modelMap.addAttribute("userList",userList);
        return "workbench/activity/index";
    }

    /**
     * 保存创建市场活动数据
     * @return
     */
    @ResponseBody
    @RequestMapping("saveCreateActivity")
    public Object saveCreateActivity(Activity activity, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Contants.SESSION_USER);
        //封装参数
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DateUtils.formateDateTime(new Date()));
        activity.setCreateBy(user.getId());

        ReturnObject returnObject = new ReturnObject();
        try {
            int i = activityService.saveCreateActivity(activity);
            if (i > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FIIL);
                returnObject.setMessage("系统忙，请稍后重试...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


        return returnObject;
    }
}
