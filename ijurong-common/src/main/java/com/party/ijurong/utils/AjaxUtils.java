package com.party.ijurong.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/27 0027.
 */
public class AjaxUtils {
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        String contentType = request.getHeader("Content-Type");
        if(StringUtils.isNotEmpty(requestType) || StringUtils.indexOf(contentType, "application/json") != -1) {
            return true;
        }
        return false;
    }
}
