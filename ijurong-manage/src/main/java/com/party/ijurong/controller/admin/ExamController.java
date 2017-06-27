package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.ResearchDto;
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


    @RequestMapping(value = "/findResearchs", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<Research> findResearchs(HttpServletRequest httpServletRequest,
                                                @ModelAttribute Research research, @RequestParam int page, @RequestParam int rows) {
        Page<Research> result = researchService.findResearchsByResearch(research, page, rows);
        return result;
    }


    @RequestMapping(value = "/findResearchExamsByResearchId/{id}", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<ResearchDto> findResearchExamsByResearchId(HttpServletRequest httpServletRequest,@PathVariable int id) {
        List<ResearchDto> result = researchExamService.getResearchByResearchId(id);
        return result;
    }


    @RequestMapping(value = "addResearch", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addResearch(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@ModelAttribute Research research)
    {
        try {
            research.setId(0);
            research.setIsDeleted(0);
            researchService.insertResearch(research);

            List<ResearchExam> list = new ArrayList<ResearchExam>();
            JSONArray jsonArray = new JSONArray(httpServletRequest.getParameter("opt"));//[{"optionContent":"1","isCorrect":"1","optionNum":"1"},{"optionContent":"1","isCorrect":"0","optionNum":"1"},{"optionContent":"1","isCorrect":"1","optionNum":"1"}]
            for (int i = 0; i < jsonArray.length(); i++) {
                ResearchExam researchExam = new ResearchExam();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                researchExam.setResearchId(research.getId());
                researchExam.setQuestionId(jsonObject.getInt("questionId"));
                researchExam.setQuestionScore(jsonObject.getInt("questionScore"));
                researchExam.setQuestionSort(jsonObject.getInt("questionSort"));
                list.add(researchExam);
            }
            researchExamService.insertResearchExam(research.getId(), list);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "updateResearch", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateResearch(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@ModelAttribute  Research research)
    {
        try {
            researchService.updateResearch(research);

            List<ResearchExam> list = new ArrayList<ResearchExam>();
            JSONArray jsonArray = new JSONArray(httpServletRequest.getParameter("opt"));//[{"optionContent":"1","isCorrect":"1","optionNum":"1"},{"optionContent":"1","isCorrect":"0","optionNum":"1"},{"optionContent":"1","isCorrect":"1","optionNum":"1"}]
            for (int i = 0; i < jsonArray.length(); i++) {
                ResearchExam researchExam = new ResearchExam();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                researchExam.setResearchId(research.getId());
                researchExam.setQuestionId(jsonObject.getInt("questionId"));
                researchExam.setQuestionScore(jsonObject.getInt("questionScore"));
                researchExam.setQuestionSort(jsonObject.getInt("questionSort"));
                list.add(researchExam);
            }
            researchExamService.updateResearchExam(research.getId(), list);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }

    }


    @RequestMapping(value = "deleteResearch/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String deleteResearch(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        try {
            int researchId=researchService.findResearchById(id).getId();
            researchExamService.deleteResearchExam(researchId);
            researchService.deleteResearch(id);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }
    }


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
