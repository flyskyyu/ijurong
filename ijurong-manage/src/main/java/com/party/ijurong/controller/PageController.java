package com.party.ijurong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用的页面跳转Controller
 * 
 * @author zhijun
 *
 */
@RequestMapping("admin")
@Controller
public class PageController {

//    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
//    public String toPage(@PathVariable("pageName") String pageName,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
//        return pageName;
//    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
        return "login";
    }


}
