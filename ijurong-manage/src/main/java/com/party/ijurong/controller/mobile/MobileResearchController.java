package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.dto.ExamPaperDto;
import com.party.ijurong.dto.UserAnswerDto;
import com.party.ijurong.pojo.Research;
import com.party.ijurong.pojo.UserAnswer;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.ResearchExamService;
import com.party.ijurong.service.ResearchService;
import com.party.ijurong.service.UserAnswerService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private MobileShiroService shiroService;
    //获取问卷列表
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


    @RequestMapping(value = "getPaper")
    @ResponseBody
    public MobileResult getPaper(HttpServletRequest httpServletRequest,int researchId) {
        MobileResult result = new MobileResult();
        try
        {
            SimpleUser user = shiroService.getUser();
            if(userAnswerService.findUserAnswersByUserAnswer(researchId,user.getUserId()).size()>0)
            {
                result.setCode(402);
                result.setData("您已经参与过了！");
            }
            else
            {
                List<ExamPaperDto> list=researchExamService.getExamPaperByResearchId(researchId);
                result.setCode(200);
                result.setData(list);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }



    @RequestMapping(value = "postAnswer")
    @ResponseBody
    public MobileResult postAnswer(String paperAnswer) {
        MobileResult result = new MobileResult();
        try
        {
            JSONObject jsonObject=new JSONObject(paperAnswer);
            JSONArray jsonArray=jsonObject.getJSONArray("answer");
            int researchId1= new JSONObject(jsonArray.get(1)).getInt("researchId");
            SimpleUser user = shiroService.getUser();
            if(userAnswerService.findUserAnswersByUserAnswer(researchId1,user.getUserId()).size()>0)
            {
                result.setCode(402);
                result.setData("您已经参与过了！");
            }
            else
            {
                int score=0;
                for(int i=0;i<jsonArray.length();i++)
                {
                    UserAnswer userAnswer=new UserAnswer();
                    JSONObject json=new JSONObject(jsonArray.get(i));
                    int id=json.getInt("id");//researchexamid
                    int researchId=json.getInt("researchId");
                    String  answerId=json.getString("answerId");
                    int questionId=json.getInt("questionId");
                    userAnswer.setResearchId(researchId);
                    userAnswer.setResearchExamId(id);
                    userAnswer.setAnswerId(answerId);
                    userAnswer.setUserId(user.getUserId());
                    userAnswer.setAnswerTime(new Date());
                    List<UserAnswerDto> listCorrectAnswer=userAnswerService.getCorrectAnswer(id);
                    String correctAnswer = getCorrectAnswerStr(listCorrectAnswer);
                    if(isArraysEquals(correctAnswer,answerId))//正确
                    {
                        userAnswer.setAnswerScore(listCorrectAnswer.get(0).getQuestionScore());
                        score+=listCorrectAnswer.get(0).getQuestionScore();
                    }
                    else
                    {
                        userAnswer.setAnswerScore(0);
                    }
                    userAnswerService.insertUserAnswer(userAnswer);
                }
//                List<UserAnswer> l=userAnswerService.findUserAnswersByUserAnswer(researchId1,user.getUserId());
//                int score=0;
//                for(UserAnswer userAnswer:l)
//                {
//                    score=score+userAnswer.getAnswerScore();
//                }
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("score",score);
                result.setCode(200);
                result.setData(map);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }


    @RequestMapping(value = "getPaperWhitAnswer")
    @ResponseBody
    public MobileResult getPaperWhitAnswer(HttpServletRequest httpServletRequest,int researchId) {
        MobileResult result = new MobileResult();
        try
        {
            SimpleUser user = shiroService.getUser();
            List<ExamPaperDto> list=researchExamService.getExamPaperByResearchId(researchId);
            if(list.size()>0)
            {
                for(int i=0;i<list.size();i++)
                {
                    int id=list.get(i).getId();
                    UserAnswer userAnswer=new UserAnswer();
                    userAnswer.setUserId(user.getUserId());
                    userAnswer.setResearchExamId(id);
                    List<UserAnswer> list2=userAnswerService.queryListByWhere(userAnswer);
                    list.get(i).setUserAnswer(list2);
                }
            }
            result.setCode(200);
            result.setData(list);
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }



    private String getCorrectAnswerStr(List<UserAnswerDto> list)
    {
        if(list.size()>0)
        {
            StringBuffer str = null;
            for(UserAnswerDto userAnswerDto:list)
            {
    //                if(userAnswerDto.getIsCorrect()==null)
    //                {
    //                    return null;
    //                }
                if(userAnswerDto.getIsCorrect()==1)
                {
                    str.append(userAnswerDto.getAnswerId()+",");
                }
            }
            return str.substring(0,str.length()-1);
        }
    return null;
    }


    /**
     * 判断2个以，分隔的字符串数组是否相等
     * 用来判断用户提交的答案是否为准确的答案
     * @param a
     * @param b
     * @return
     */
    private boolean isArraysEquals(String a,String b)
    {
        if(b.equals("")||b==null)
        {
            return false;
        }
        String str[] = a.split(",");
        int aa[] = new int[str.length];
        for(int i=0;i<str.length;i++) {
            try {
                aa[i] = Integer.parseInt(str[i]);
            }catch (NumberFormatException e)
            {
                return  true;
            }
        }
        String str2[] = b.split(",");//String str2[] = b.split("-,.-,.-");
        int bb[] = new int[str2.length];
        for(int i=0;i<str2.length;i++) {
            bb[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(aa);//排序
        Arrays.sort(bb);
        return  Arrays.equals(aa, bb);
    }




}
