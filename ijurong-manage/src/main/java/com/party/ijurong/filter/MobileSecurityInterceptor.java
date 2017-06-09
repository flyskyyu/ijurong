package com.party.ijurong.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.StaffTokenDto;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.StaffTokenService;
import com.party.ijurong.web.UserThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cloud on 2017/5/27.
 */
public class MobileSecurityInterceptor implements HandlerInterceptor{
    @Autowired
    private MobileShiroService shiroService;
    @Autowired
    private StaffTokenService tokenService;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authentication");
        if(StringUtils.isEmpty(token)) {
            printJsonMsg(401, "没有token", null, response);
            return false;
        }
        //从session中取user
        SimpleUser simpleUser = shiroService.getUser(token);
        if(simpleUser == null) {
            //查找数据库是否有登录信息
            StaffTokenDto dto = tokenService.queryByToken(token);
            if(dto == null) {
                printJsonMsg(401, "token失效", null, response);
                return false;
            }
            simpleUser = new SimpleUser(dto.getStaff());
            simpleUser.setToken(token);
            shiroService.saveUserInSession(simpleUser);
        }
        UserThreadLocal.set(simpleUser);
        return true;
    }

    private void printJsonMsg(int code, String msg, Object data, HttpServletResponse response) {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            MobileResult result = new MobileResult();
            result.setCode(code);
            result.setMsg(msg);
            result.setData(null);
            out.print(objectMapper.writeValueAsString(result));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.set(null);
    }
}
