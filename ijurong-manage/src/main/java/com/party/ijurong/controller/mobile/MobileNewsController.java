package com.party.ijurong.controller.mobile;


import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.pojo.News;
import com.party.ijurong.pojo.Programa;
import com.party.ijurong.service.NewsService;
import com.party.ijurong.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller
@RequestMapping("mobile/news")
public class MobileNewsController {

    @Autowired
    private ProgramaService programaService;

    @Autowired
    private NewsService newsService;

    //获取栏目
    @RequestMapping(value = "getPrograma")
    @ResponseBody
    public MobileResult getMessageType(HttpServletRequest httpServletRequest) {
        MobileResult result = new MobileResult();
        try
        {
            Page<Programa> page = programaService.findProgramasByPrograma(new Programa(), 1, 999, ConstantOrigin.C1_NEWS);
            result.setCode(200);
            result.setData(page.getRows());
        }catch (Exception e)
        {
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }


    //获取新闻
    @RequestMapping(value = "getNews")
    @ResponseBody
    public MobileResult getNews(News news, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        try
        {
            if(news.getProgramaId()==null)
            {
                result.setCode(402);
                result.setMsg("参数错误");
                return  result;
            }
            news.setStatus(2);
            Page<News> p = newsService.findNewssByNews(news, page, rows,"create_time DESC");
            result.setCode(200);
            result.setData(p.getRows());
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }

    //获取新闻
    @RequestMapping(value = "getHotNews")
    @ResponseBody
    public MobileResult getHotNews(News news, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        try
        {
            if(news.getProgramaId()==null)
            {
                result.setCode(402);
                result.setMsg("参数错误");
                return  result;
            }
            news.setStatus(2);
            Page<News> p = newsService.findNewssByNews(news, page, rows,"check_num DESC");
            result.setCode(200);
            result.setData(p.getRows());
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }


    //更新新闻点击数
    @RequestMapping(value = "updateNewsCheckNum")
    @ResponseBody
    public MobileResult updateNewsCheckNum(int id) {
        MobileResult result = new MobileResult();
        try
        {
             newsService.updateCheckNum(id);
            result.setCode(200);
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }





}
