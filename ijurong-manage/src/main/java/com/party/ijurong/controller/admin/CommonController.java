package com.party.ijurong.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.party.ijurong.service.FileUploadService;
import com.party.ijurong.utils.FileUtils;
import com.party.ijurong.utils.RandomValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yu on 2017/5/31.
 */

@Controller
public class CommonController {
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "findValidateImage", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public void findValidateImage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try
        {
            randomValidateCode.getRandcode(request, response);// 输出图片方法
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @RequestMapping("admin/common/fileUpload")
    @ResponseBody
    public String uploadFile(MultipartFile file) throws IOException {
        String url = fileUploadService.upload(file.getInputStream(), FileUtils.getRandomFilename(file.getOriginalFilename()));
        return url;
    }
}