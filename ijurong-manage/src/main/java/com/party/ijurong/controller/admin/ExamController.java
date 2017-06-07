package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.pojo.ExamQuestion;
import com.party.ijurong.pojo.MessageType;
import com.party.ijurong.service.CarService;
import com.party.ijurong.service.ExamQuestionService;
import com.party.ijurong.service.ShiroService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Copyright ©, 2016-2056
 * FileName:  ExamController
 *
 * @author CS-711701-00027
 * @version 1.0
 * @Date: 2017/6/7
 * Description:
 * Function List:
 * 1. -------
 * History:
 * maurice 16/02/12 1.0 build this moudle
 */
@Controller
@RequestMapping("admin/exam")
public class ExamController {
    @Autowired
    private ExamQuestionService examQuestionService;



    @RequestMapping(value = "addExamQuestion", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addMessageType(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)
    {
         ExamQuestion examQuestion=new ExamQuestion();
        long messageTypeCount= examQuestionService.findExamQuestionsByName(examQuestion.getQuestionContent());
        if (messageTypeCount==0)
        {
          //
            return "success";
        }
        else if(messageTypeCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }
}
