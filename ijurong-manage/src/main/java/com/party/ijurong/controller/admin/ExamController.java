package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ExamAnswerService examAnswerService;

    @Autowired
    private ResearchService researchService;

    @Autowired
    private ResearchExamService researchExamService;


    @RequestMapping(value = "/findExamQuestionsByName", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<ExamQuestion> findExamQuestionsByName(HttpServletRequest httpServletRequest,@RequestParam String q, @RequestParam int page, @RequestParam int rows) {
        ExamQuestion examQuestion=new ExamQuestion();
        examQuestion.setQuestionContent(q);
        Page<ExamQuestion> result = examQuestionService.findExamQuestionsByExamQuestion(examQuestion, page, rows);
        return result;
    }

    @RequestMapping(value = "/findExamQuestions", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<ExamQuestion> findExamQuestions(HttpServletRequest httpServletRequest,
                                        @ModelAttribute ExamQuestion examQuestion, @RequestParam int page, @RequestParam int rows) {
        Page<ExamQuestion> result = examQuestionService.findExamQuestionsByExamQuestion(examQuestion, page, rows);
        return result;
    }

    @RequestMapping(value = "/findExamAnswersByQuestionId/{id}", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<ExamAnswer> findExamAnswersByQuestionId(HttpServletRequest httpServletRequest,@PathVariable int id) {
        List<ExamAnswer> result = examAnswerService.findExamAnswersByQuestionId(id);
        return result;
    }


    @RequestMapping(value = "addExamQuestion", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addExamQuestion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@ModelAttribute ExamQuestion examQuestion)
    {
        try {
            examQuestion.setId(0);
            examQuestionService.insertExamQuestion(examQuestion);

            List<ExamAnswer> list = new ArrayList<ExamAnswer>();
            JSONArray jsonArray = new JSONArray(httpServletRequest.getParameter("opt"));//[{"optionContent":"1","isCorrect":"1","optionNum":"1"},{"optionContent":"1","isCorrect":"0","optionNum":"1"},{"optionContent":"1","isCorrect":"1","optionNum":"1"}]
            for (int i = 0; i < jsonArray.length(); i++) {
                ExamAnswer examAnswer = new ExamAnswer();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                examAnswer.setOptionContent(jsonObject.get("optionContent").toString());
                examAnswer.setIsCorrect(jsonObject.getInt("isCorrect"));
                examAnswer.setOptionNum(jsonObject.getInt("optionNum"));
                list.add(examAnswer);
            }
            examAnswerService.insertExamAnswer(examQuestion.getId(), list);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "updateExamQuestion", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateExamQuestion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@ModelAttribute ExamQuestion examQuestion)
    {
        try {
            examQuestionService.updateExamQuestion(examQuestion);

            List<ExamAnswer> list = new ArrayList<ExamAnswer>();
            JSONArray jsonArray = new JSONArray(httpServletRequest.getParameter("opt"));//[{"optionContent":"1","isCorrect":"1","optionNum":"1"},{"optionContent":"1","isCorrect":"0","optionNum":"1"},{"optionContent":"1","isCorrect":"1","optionNum":"1"}]
            for (int i = 0; i < jsonArray.length(); i++) {
                ExamAnswer examAnswer = new ExamAnswer();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                examAnswer.setOptionContent(jsonObject.get("optionContent").toString());
                examAnswer.setIsCorrect(jsonObject.getInt("isCorrect"));
                examAnswer.setOptionNum(jsonObject.getInt("optionNum"));
                list.add(examAnswer);
            }
            examAnswerService.updateExamAnswer(examQuestion.getId(), list);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }

    }

    @RequestMapping(value = "deleteExamQuestion/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String deleteExamQuestion(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        try {
            int questionId=examQuestionService.findExamQuestionById(id).getId();
            examAnswerService.deleteExamAnswer(questionId);
            examQuestionService.deleteExamQuestion(id);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }
    }
}
