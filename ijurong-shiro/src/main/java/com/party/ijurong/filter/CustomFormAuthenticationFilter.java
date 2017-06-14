package com.party.ijurong.filter;

import com.party.ijurong.service.ShiroService;
import com.party.ijurong.utils.AjaxUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cloud on 2017/5/16.
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
    @Autowired
    private ShiroService shiroService;

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        //登陆页面并且不是ajax请求的场合，判断验证码
        if (isLoginRequest(request, response) && !AjaxUtils.isAjaxRequest(servletRequest)) {

            HttpSession session = servletRequest.getSession();
            //从session中取出正确的验证码
            String validateCode = (String) session.getAttribute("validateCode");

            //取出用户输入的验证码
            String randomcode = servletRequest.getParameter("randomcode");
            if(randomcode == null) {
                //第一次进入登录页面的场合
                servletRequest.setAttribute(getFailureKeyAttribute(), "firstToLogin");
                return true;
            }
            if(validateCode == null || !validateCode.equalsIgnoreCase(randomcode)) {
                servletRequest.setAttribute(getFailureKeyAttribute(), "randomCodeError");
                //不再验证username,password,直接返回登陆页面
                return true;
            }
        }
        //ajax请求且不是登录页面的情况
        if(AjaxUtils.isAjaxRequest(servletRequest) && !isLoginRequest(request, response)) {
            //返回错误信息
            printErrStatus(401, (HttpServletResponse) response);
            return false;//不继续执行
        }
        return super.onAccessDenied(request, response);
    }

    private void printErrStatus(int code, HttpServletResponse response) {
        response.setStatus(code);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        shiroService.getUser(); //在session中初始化user数据
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        //ajax登录成功的情况
        if(AjaxUtils.isAjaxRequest(servletRequest)) {
            //登录的场合，直接返回
            printErrStatus(401, (HttpServletResponse) response);
            return false;
        } else {
            servletResponse.sendRedirect(getSuccessUrl());
            return false;
            //return super.onLoginSuccess(token, subject, request, response);
        }
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if(AjaxUtils.isAjaxRequest(servletRequest)) {
            printErrStatus(401, (HttpServletResponse) response);
            return false;
        }
        return super.onLoginFailure(token, e, request, response);
    }

    @Override
    protected String getPassword(ServletRequest request) {
        String password = super.getPassword(request);
        return DigestUtils.md5Hex(password);
    }
}
