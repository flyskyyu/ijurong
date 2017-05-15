package com.party.ijurong.controller;

import com.party.ijurong.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/2/20.
 */
@Controller
@RequestMapping("/sso")
public class SSOController {
    @Autowired
    private ShiroService shiroService;

    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password) {
        int status = shiroService.login(username, password);
        return  status + "";
    }

}
