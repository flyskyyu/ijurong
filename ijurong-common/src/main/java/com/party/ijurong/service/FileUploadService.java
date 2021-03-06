package com.party.ijurong.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Calendar;

/**
 * Created by yu on 2017/5/24.
 */
@Service
public class FileUploadService {

    @Value("${uploadPath}")
    private String uploadPath;

    @Value("${webSite}")
    private String webSite;


    public String upload(InputStream inputStream, String name) throws IOException {
        String time=getDateTime();
        File file = new File(uploadPath + "/"+time+"/");
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream bos = new FileOutputStream(uploadPath + "/"+time+"/"
                + name);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);// 将文件写入服务器
        }
        bos.close();
        inputStream.close();
        return webSite+"/static/"+time+"/"+name;
    }

    public String getDateTime()
    {
        Calendar now = Calendar.getInstance();
        String year=now.get(Calendar.YEAR)+"";
        String month=(now.get(Calendar.MONTH) + 1)+"";
        String day=now.get(Calendar.DAY_OF_MONTH)+"";
        return year+month+day;
    }

}
