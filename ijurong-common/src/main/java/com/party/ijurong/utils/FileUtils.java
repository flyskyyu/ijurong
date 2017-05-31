package com.party.ijurong.utils;

import java.util.UUID;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
public class FileUtils {
    public static String getRandomFilename(String originalName) {
        return UUID.randomUUID().toString()+"."+originalName.replace(".", "-").split("-")[originalName.replace(".","-").split("-").length-1];
    }
}
