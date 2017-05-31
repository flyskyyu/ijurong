package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.AppSkinVersion;
import com.party.ijurong.pojo.AppSkins;
import com.party.ijurong.pojo.Message;
import com.party.ijurong.pojo.AppShufflingPic;
import com.party.ijurong.service.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class AppSetController {


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
                try {
                    url = fileUploadService.upload(file.getInputStream(),UUID.randomUUID().toString()+"."+file.getOriginalFilename().replace(".","-").split("-")[file.getOriginalFilename().replace(".","-").split("-").length-1]);
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
    public String updateAppShufflingPic(@RequestParam("file") MultipartFile file,HttpServletRequest httpServletRequest, @ModelAttribute AppShufflingPic appShufflingPic)
    {

        if(file.isEmpty()){
            System.out.println("文件未上传");
        }else{
            System.out.println("文件长度: " + file.getSize());
            System.out.println("文件类型: " + file.getContentType());
            System.out.println("文件名称: " + file.getName());
            System.out.println("文件原名: " + file.getOriginalFilename());
            try {
                String url = fileUploadService.upload(file.getInputStream(),UUID.randomUUID().toString()+"."+file.getOriginalFilename().replace(".","-").split("-")[file.getOriginalFilename().replace(".","-").split("-").length-1]);
                appShufflingPic.setUrl(url);
                appShufflingPic.setCreateTime(new Date());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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


    @Autowired
    private AppSkinsService appSkinsService;



    @RequestMapping(value = "/findAppSkinss", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<AppSkins> findAppSkinss(HttpServletRequest httpServletRequest,
                                        @ModelAttribute AppSkins appSkins, @RequestParam int page, @RequestParam int rows) {
        Page<AppSkins> result = appSkinsService.findAppSkinssByAppSkins(appSkins, page, rows);
        return result;
    }

    @RequestMapping(value = "addAppSkins", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addAppSkins(HttpServletRequest httpServletRequest,@RequestParam("file") MultipartFile file, @ModelAttribute AppSkins appSkins)
    {
        long appSkinsCount= appSkinsService.findAppSkinssByName(appSkins.getName());
        if (appSkinsCount==0)
        {
            String url="";
            if(file.isEmpty()){
                System.out.println("文件未上传");
            }else{
                System.out.println("文件长度: " + file.getSize());
                System.out.println("文件类型: " + file.getContentType());
                System.out.println("文件名称: " + file.getName());
                System.out.println("文件原名: " + file.getOriginalFilename());
                try {
                    url = fileUploadService.upload(file.getInputStream(),UUID.randomUUID().toString()+"."+file.getOriginalFilename().replace(".","-").split("-")[file.getOriginalFilename().replace(".","-").split("-").length-1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            appSkins.setId(0);
            appSkins.setUrl(url);
            appSkins.setCreateTime(new Date());
            appSkinsService.insertAppSkins(appSkins);
            return "success";
        }
        else if(appSkinsCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateAppSkins", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateAppSkins(@RequestParam("file") MultipartFile file,HttpServletRequest httpServletRequest, @ModelAttribute AppSkins appSkins)
    {

        if(file.isEmpty()){
            System.out.println("文件未上传");
        }else{
            System.out.println("文件长度: " + file.getSize());
            System.out.println("文件类型: " + file.getContentType());
            System.out.println("文件名称: " + file.getName());
            System.out.println("文件原名: " + file.getOriginalFilename());
            try {
                String url = fileUploadService.upload(file.getInputStream(),UUID.randomUUID().toString()+"."+file.getOriginalFilename().replace(".","-").split("-")[file.getOriginalFilename().replace(".","-").split("-").length-1]);
                appSkins.setUrl(url);
                appSkins.setCreateTime(new Date());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        appSkinsService.updateAppSkins(appSkins);
        return "success";
    }

    @RequestMapping(value = "delectAppSkins/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectAppSkins(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        appSkinsService.deleteAppSkins(id);
        return "success";
    }




    @Autowired
    private AppSkinVersionService appSkinVersionService;



    @RequestMapping(value = "/findAppSkinVersions", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<AppSkinVersion> findAppSkinVersions(HttpServletRequest httpServletRequest,
                                                    @ModelAttribute AppSkinVersion appSkinVersion, @RequestParam int page, @RequestParam int rows) {
        Page<AppSkinVersion> result = appSkinVersionService.findAppSkinVersionsByAppSkinVersion(appSkinVersion, page, rows);
        return result;
    }

    @RequestMapping(value = "addAppSkinVersion", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addAppSkinVersion(HttpServletRequest httpServletRequest,@RequestParam("file") MultipartFile file, @ModelAttribute AppSkinVersion appSkinVersion)
    {
        long appSkinVersionCount= appSkinVersionService.findAppSkinVersionsByName(appSkinVersion.getVersion());
        if (appSkinVersionCount==0)
        {
            appSkinVersion.setId(0);
            appSkinVersion.setCreateTime(new Date());
            appSkinVersionService.insertAppSkinVersion(appSkinVersion);
            return "success";
        }
        else if(appSkinVersionCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateAppSkinVersion", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateAppSkinVersion(@RequestParam("file") MultipartFile file,HttpServletRequest httpServletRequest, @ModelAttribute AppSkinVersion appSkinVersion)
    {

        appSkinVersionService.updateAppSkinVersion(appSkinVersion);
        return "success";
    }

    @RequestMapping(value = "delectAppSkinVersion/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectAppSkinVersion(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        appSkinVersionService.deleteAppSkinVersion(id);
        return "success";
    }


}