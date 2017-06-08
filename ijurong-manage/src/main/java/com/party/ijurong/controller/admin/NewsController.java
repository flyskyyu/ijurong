package com.party.ijurong.controller.admin;

import com.google.gson.JsonObject;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
@RequestMapping("admin/news")
@Controller
public class NewsController {

    @Autowired
    private ProgramaService programaService;

    @Autowired
    private NewsSpecialService newsSpecialService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ShiroService shiroService;


    @Autowired
    private FileUploadService fileUploadService;




    @RequestMapping(value = "/findProgramas", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<Programa> findProgramas(HttpServletRequest httpServletRequest,
                                        @ModelAttribute Programa programa, @RequestParam int page, @RequestParam int rows) {
        Page<Programa> result = programaService.findProgramasByPrograma(programa, page, rows, ConstantOrigin.C1_NEWS);
        return result;
    }

    @RequestMapping(value = "/findAllProgramas", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<Programa> findAllProgramas(HttpServletRequest httpServletRequest) {
        Page<Programa> result = programaService.findProgramasByPrograma(new Programa(), 1, 999, ConstantOrigin.C1_NEWS);
        return result.getRows();
    }

    @RequestMapping(value = "addPrograma", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addPrograma(HttpServletRequest httpServletRequest, @ModelAttribute Programa programa)
    {
        long programaCount= programaService.findProgramasByName(programa.getName(), ConstantOrigin.C1_NEWS);
        if (programaCount==0)
        {
            programa.setCreateTime(new Date());
            SimpleUser user = shiroService.getUser();
            programa.setCreateUserId(user.getUserId());
            programaService.insertPrograma(programa, ConstantOrigin.C1_NEWS);
            return "success";
        }
        else if(programaCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updatePrograma", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updatePrograma(HttpServletRequest httpServletRequest, @ModelAttribute Programa programa)
    {
        SimpleUser user = shiroService.getUser();
        programa.setCreateUserId(user.getUserId());
        programaService.updatePrograma(programa);
        return "success";
    }

    @RequestMapping(value = "delectPrograma/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectPrograma(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        programaService.deletePrograma(id);
        return "success";
    }


    @RequestMapping(value = "/findNewsSpecials", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<NewsSpecial> findNewsSpecials(HttpServletRequest httpServletRequest,
                                              @ModelAttribute NewsSpecial newsSpecial, @RequestParam int page, @RequestParam int rows) {
        Page<NewsSpecial> result = newsSpecialService.findNewsSpecialsByNewsSpecial(newsSpecial, page, rows);
        return result;
    }

    @RequestMapping(value = "/findAllNewsSpecials", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<NewsSpecial> findAllNewsSpecials(HttpServletRequest httpServletRequest) {
        Page<NewsSpecial> result = newsSpecialService.findNewsSpecialsByNewsSpecial(new NewsSpecial(), 1, 999);
        return result.getRows();
    }

    @RequestMapping(value = "addNewsSpecial", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addNewsSpecial(HttpServletRequest httpServletRequest, @ModelAttribute NewsSpecial newsSpecial)
    {
        long newsSpecialCount= newsSpecialService.findNewsSpecialsByName(newsSpecial.getName());
        if (newsSpecialCount==0)
        {
            newsSpecial.setCreateTime(new Date());
            SimpleUser user = shiroService.getUser();
            newsSpecial.setCreateUserId(user.getUserId());
            newsSpecialService.insertNewsSpecial(newsSpecial);
            return "success";
        }
        else if(newsSpecialCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateNewsSpecial", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateNewsSpecial(HttpServletRequest httpServletRequest, @ModelAttribute NewsSpecial newsSpecial)
    {

        SimpleUser user = shiroService.getUser();
        newsSpecial.setCreateUserId(user.getUserId());
        newsSpecialService.updateNewsSpecial(newsSpecial);
        return "success";
    }

    @RequestMapping(value = "delectNewsSpecial/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectNewsSpecial(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        newsSpecialService.deleteNewsSpecial(id);
        return "success";
    }



    @RequestMapping(value = "/findNewss", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<News> findNewss(HttpServletRequest httpServletRequest,
                                @ModelAttribute News news, @RequestParam int page, @RequestParam int rows) {
        Page<News> result = newsService.findNewssByNews(news, page, rows);
        return result;
    }

    @RequestMapping(value = "addNews", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addNews(@RequestParam("file") MultipartFile file,HttpServletRequest httpServletRequest, @ModelAttribute News news)
    {

        try {
            String url="";
            if(!file.isEmpty()){
                System.out.println("文件长度: " + file.getSize());
                System.out.println("文件类型: " + file.getContentType());
                System.out.println("文件名称: " + file.getName());
                System.out.println("文件原名: " + file.getOriginalFilename());
                url = fileUploadService.upload(file.getInputStream(), UUID.randomUUID().toString()+"."+file.getOriginalFilename().replace(".","-").split("-")[file.getOriginalFilename().replace(".","-").split("-").length-1]);
            }

            news.setCreateTime(new Date());
            SimpleUser user = shiroService.getUser();
            news.setCreateUserId(user.getUserId());
            news.setUrl(url);
            news.setId(0);
            news.setStatus(1);
            newsService.insertNews(news);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "updateNews", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateNews(@RequestParam("file") MultipartFile file,HttpServletRequest httpServletRequest, @ModelAttribute News news)
    {
        try {
            if (!file.isEmpty()) {
                System.out.println("文件长度: " + file.getSize());
                System.out.println("文件类型: " + file.getContentType());
                System.out.println("文件名称: " + file.getName());
                System.out.println("文件原名: " + file.getOriginalFilename());
                String url = fileUploadService.upload(file.getInputStream(), UUID.randomUUID().toString() + "." + file.getOriginalFilename().replace(".", "-").split("-")[file.getOriginalFilename().replace(".", "-").split("-").length - 1]);
                news.setUrl(url);
            }
            news.setCreateTime(new Date());
            SimpleUser user = shiroService.getUser();
            news.setCreateUserId(user.getUserId());
            newsService.updateNews(news);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "delectNews/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectNews(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        News news1=newsService.findNewsById(id);
        newsService.deleteNews(id);
        return "success";
    }


    //发布
    @RequestMapping(value = "sendNews/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String sendNews(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        News news=newsService.findNewsById(id);
        SimpleUser user = shiroService.getUser();
        news.setReleaseUserId(user.getUserId());
        news.setReleaseTime(new Date());
        news.setStatus(2);
        newsService.updateNews(news);
        return "success";
    }

}
