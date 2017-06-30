package com.party.ijurong.controller.admin;

import com.party.ijurong.service.ShiroService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Cloud on 2017/5/25.
 */
@Controller
public class LoginController {
    @Autowired
    private ShiroService shiroService;

    @RequestMapping("admin/login")
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
            } else if("firstToLogin".equals(exceptionName)) {
                //第一次进入登录页面不显示错误信息
            } else {
                request.setAttribute("errMsg", "未知错误");
            }
        }
        //已经成功到主页面
        if(shiroService.getUser() != null) {
            return "redirect:/admin/main";
        }
        //登录失败还到login页面
        return "admin/login";
    }

    @RequestMapping("validateCode")
    @ResponseBody
    public boolean validateCode(String validateCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("validateCode");
        if(sessionCode == null) return false;
        return sessionCode.equalsIgnoreCase(validateCode);
    }
}
