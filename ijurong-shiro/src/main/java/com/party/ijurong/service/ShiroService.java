package com.party.ijurong.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by Cloud on 2017/2/10.
 */
@Service
public class ShiroService {
    public final static int LOGIN_OK = 1;
    public final static int LOGIN_UNKNOWN_ACCOUNT = 2;
    public final static int LOGIN_OTHER_ERROR = 3;

    public int login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return LOGIN_UNKNOWN_ACCOUNT;
        } catch (Exception e) {
            return LOGIN_OTHER_ERROR;
        }
        return LOGIN_OK;
    }
}
