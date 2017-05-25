package com.party.ijurong.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Cloud on 2017/5/25.
 */
@Controller
public class LoginController {
    @RequestMapping("admin/loginUrl")
    public String login(HttpServletRequest request) {
        //从登录失败中获取异常信息
        String exceptionName = (String)request.getAttribute("shiroLoginFailure");
        //发生异常
        if(StringUtils.isNotEmpty(exceptionName)) {
            if(UnknownAccountException.class.getName().equals(exceptionName)) {
                request.setAttribute("errMsg", "用户不存在");
            } else if(IncorrectCredentialsException.class.getName().equals(exceptionName)) {
                request.setAttribute("errMsg", "密码错误");
            } else if("randomCodeError".equals(exceptionName)) {
                request.setAttribute("errMsg", "验证码错误");
            } else {
                request.setAttribute("errMsg", "未知错误");
            }
        }
        //登录失败还到login页面
        return "login";
    }
}
