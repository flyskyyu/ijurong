package com.party.ijurong.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by yu on 2017/5/24.
 */
@Service
public class FileUploadService {

    @Value("${uploadPath}")
    private String uploadPath;

    public void upload(InputStream inputStream, String name) throws IOException {
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream bos = new FileOutputStream(uploadPath + "/"
                + name);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);// 将文件写入服务器
        }
        bos.close();
        inputStream.close();
    }


}
