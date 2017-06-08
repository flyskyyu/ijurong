package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.pojo.Research;
import com.party.ijurong.service.ResearchExamService;
import com.party.ijurong.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright ©, 2016-2056
 * FileName:  MobileResearchController
 *
 * @author CS-711701-00027
 * @version 1.0
 * @Date: 2017/6/8
 * Description:
 * Function List:
 * 1. -------
 * History:
 * maurice 16/02/12 1.0 build this moudle
 */
@Controller
@RequestMapping("mobile/exam")
public class MobileResearchController {

    @Autowired
    private ResearchExamService researchExamService;

    @Autowired
    private ResearchService researchService;

    //获取问卷
    @RequestMapping(value = "getResearch")
    @ResponseBody
    public MobileResult getMessageType(HttpServletRequest httpServletRequest,int status, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        try
        {
            PageInfo<Research> p= researchService.getReachByStatus(status,page,rows);
            result.setCode(200);
            result.setData(p.getList());
        }catch (Exception e)
        {
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }



}
