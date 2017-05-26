package com.party.ijurong.filter;

import com.party.ijurong.service.ShiroService;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Cloud on 2017/5/16.
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
    @Autowired
    private ShiroService shiroService;

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //登陆页面的场合，判断验证码
        if (isLoginRequest(request, response)) {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            HttpSession session = servletRequest.getSession();
            //从session中取出正确的验证码
            String validateCode = (String) session.getAttribute("validateCode");

            //取出用户输入的验证码
            String randomcode = servletRequest.getParameter("randomcode");
            if(validateCode == null || !validateCode.equals(randomcode)) {
                servletRequest.setAttribute(getFailureKeyAttribute(), "randomCodeError");
                //不再验证username,password,直接返回登陆页面
                return true;
            }
        }
        return super.onAccessDenied(request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        shiroService.getUser(); //在session中初始化user数据
        return super.onLoginSuccess(token, subject, request, response);
    }
}
