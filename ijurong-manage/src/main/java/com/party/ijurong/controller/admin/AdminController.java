package com.party.ijurong.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.ijurong.pojo.Permission;
import com.party.ijurong.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Cloud on 2017/6/21.
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("main")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();
        List<Permission> menus = shiroService.getAllMenus();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(menus);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        mv.addObject("menus", json);
        mv.setViewName("admin/main");
        return mv;
    }

    @RequestMapping("menu")
    public ModelAndView menu() {
        ModelAndView mv = new ModelAndView();
        List<Permission> menus = shiroService.getAllMenus();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(menus);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        mv.addObject("menus", json);
        mv.setViewName("admin/menu");
        return mv;
    }
}
