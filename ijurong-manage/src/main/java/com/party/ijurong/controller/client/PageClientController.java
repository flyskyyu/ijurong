package com.party.ijurong.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright ©, 2016-2056
 * FileName:  AdminController
 *
 * @author CS-711701-00027
 * @version 1.0
 * @Date: 2017/5/16
 * Description:
 * Function List:
 * 1. -------
 * History:
 * maurice 16/02/12 1.0 build this moudle
 */
@RequestMapping("client")
@Controller
public class PageClientController {

    @RequestMapping(value = "{page}", method = RequestMethod.GET)
    public String toPage1(@PathVariable("page") String pageName) {
        return "client/" + pageName;
    }

    @RequestMapping(value = "{page}/{page1}", method = RequestMethod.GET)
    public String toPage2(@PathVariable("page") String pageName, @PathVariable("page1") String pageName1) {
        return "client/" + pageName + "/" + pageName1;
    }

    @RequestMapping(value = "{page}/{page1}/{page2}", method = RequestMethod.GET)
    public String toPage3(@PathVariable("page") String pageName,  @PathVariable("page1") String pageName1,  @PathVariable("page2") String pageName2) {
        return "client/" + pageName + "/" + pageName1 + "/" + pageName2;
    }
}
