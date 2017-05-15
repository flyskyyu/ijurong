package com.party.ijurong.controller;

import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.service.ApiService;
import com.party.ijurong.service.RedisService;
import com.party.ijurong.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 通用的页面跳转Controller
 * 
 * @author zhijun
 *
 */
@Controller
public class TestController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private ApiService apiService;
    @Autowired
    private ShiroService shiroService;
    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "testpost", method = RequestMethod.GET)
    @ResponseBody
    public String toPage() throws IOException {
        redisService.del("a:1");
        redisService.expire("a:2", 100);
        Subject subject = SecurityUtils.getSubject();
        SimpleUser user = (SimpleUser)subject.getPrincipal();
        Object val = subject.getSession().getAttribute("abc");
        subject.getSession().setAttribute("abc", "111");
        return "testpost";
    }

    @RequestMapping(value = "testlogin", method = RequestMethod.GET)
    @ResponseBody
    public String testLogin() throws IOException {
        int code = shiroService.login("cloud", "123456");


        return "testpost";
    }

    @RequestMapping(value = "auth/testauth", method = RequestMethod.GET)
    @ResponseBody
    public String testAuth() throws IOException {

        return "testpost";
    }



}
