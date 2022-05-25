package com.yang.crm.settings.web.controller;

import com.yang.crm.commons.Contants;
import com.yang.crm.commons.dimain.ReturnObject;
import com.yang.crm.settings.domain.User;
import com.yang.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("settings/qx/user/")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 由index页面转发到登录页面
     *
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "settings/qx/user/login";
    }

    /**
     * 处理用户登录请求
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("loginHandler")
    public Object login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        User user = userService.queryUserByLoginActAndPwd(map);
        if (user == null) {
            return new ReturnObject(Contants.RETURN_OBJECT_CODE_FIIL, "用户名或密码错误");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowStr = sdf.format(new Date());
            //查看账户是否过期
            if (nowStr.compareTo(user.getExpireTime()) > 0) {
                return new ReturnObject(Contants.RETURN_OBJECT_CODE_FIIL, "账户状态已过期");
            } else if (Contants.RETURN_OBJECT_CODE_FIIL.equals(user.getLockState())) { //状态被锁定
                return new ReturnObject(Contants.RETURN_OBJECT_CODE_FIIL,"当前账户被锁定");
            } else if (!user.getAllowIps().contains(req.getRemoteAddr())) {//查看访问ip是否安全
                return new ReturnObject(Contants.RETURN_OBJECT_CODE_FIIL,"ip受限");
            } else {//登录成功,判断是否需要记住密码
                if ("true".equals(isRemPwd)){
                    Cookie c1 = new Cookie("loginAct", user.getLoginAct());
                    Cookie c2 = new Cookie("loginPwd", user.getLoginPwd());
                    c1.setMaxAge(60*60*24*10);
                    c2.setMaxAge(60*60*24*10);
                    resp.addCookie(c1);
                    resp.addCookie(c2);
                }else {
                    //没有过期的cookie删除
                    Cookie c1 = new Cookie("loginAct", "1");
                    Cookie c2 = new Cookie("loginPwd", "1");
                    c1.setMaxAge(0);
                    c2.setMaxAge(0);
                    resp.addCookie(c1);
                    resp.addCookie(c2);
                    System.out.println(c1.getName()+c1.getValue());
                }
                req.getSession() .setAttribute(Contants.SESSION_USER,user);
                return new ReturnObject(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }
        }
    }
}
