package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Message;
import com.party.ijurong.pojo.AppShufflingPic;
import com.party.ijurong.service.FileUploadService;
import com.party.ijurong.service.MessageService;
import com.party.ijurong.service.AppShufflingPicService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
@RequestMapping("admin/appSet")
@Controller
public class AppShufflingPicController {

    @Autowired
    private AppShufflingPicService appShufflingPicService;

    @Autowired
    private FileUploadService fileUploadService;


    @RequestMapping(value = "/findAppShufflingPics", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<AppShufflingPic> findAppShufflingPics(HttpServletRequest httpServletRequest,
                                                      @ModelAttribute AppShufflingPic appShufflingPic, @RequestParam int page, @RequestParam int rows) {
        Page<AppShufflingPic> result = appShufflingPicService.findAppShufflingPicsByAppShufflingPic(appShufflingPic, page, rows);
        return result;
    }

    @RequestMapping(value = "addAppShufflingPic", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addAppShufflingPic(HttpServletRequest httpServletRequest,@RequestParam("file") MultipartFile file, @ModelAttribute AppShufflingPic appShufflingPic)
    {
        long appShufflingPicCount= appShufflingPicService.findAppShufflingPicsByName(appShufflingPic.getName());
        if (appShufflingPicCount==0)
        {
            String url="";
            if(file.isEmpty()){
                System.out.println("文件未上传");
            }else{
                System.out.println("文件长度: " + file.getSize());
                System.out.println("文件类型: " + file.getContentType());
                System.out.println("文件名称: " + file.getName());
                System.out.println("文件原名: " + file.getOriginalFilename());
                url=UUID.randomUUID().toString()+"."+file.getOriginalFilename().replace(".","-").split("-")[file.getOriginalFilename().replace(".","-").split("-").length-1];
                try {
                    fileUploadService.upload(file.getInputStream(),url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            appShufflingPic.setId(0);
            appShufflingPic.setUrl(url);
            appShufflingPic.setIsDelete(0);
            appShufflingPic.setCreateTime(new Date());
            appShufflingPicService.insertAppShufflingPic(appShufflingPic);
            return "success";
        }
        else if(appShufflingPicCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateAppShufflingPic", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateAppShufflingPic(HttpServletRequest httpServletRequest, @ModelAttribute AppShufflingPic appShufflingPic)
    {
        appShufflingPicService.updateAppShufflingPic(appShufflingPic);
        return "success";
    }

    @RequestMapping(value = "delectAppShufflingPic/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectAppShufflingPic(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        appShufflingPicService.deleteAppShufflingPic(id);
        return "success";
    }



}