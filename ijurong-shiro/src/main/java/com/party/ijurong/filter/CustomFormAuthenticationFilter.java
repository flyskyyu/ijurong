package com.party.ijurong.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Cloud on 2017/5/16.
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
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
}