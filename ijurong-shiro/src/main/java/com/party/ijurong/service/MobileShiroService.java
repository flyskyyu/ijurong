package com.party.ijurong.service;

import com.party.ijurong.bean.SimpleUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cloud on 2017/5/27.
 */
@Service
public class MobileShiroService {
    private final static String prefix = "MOBILE_SESSION_KEY:";
    public final static String USER_KEY = "MOBILE_USER_KEY";
    @Autowired
    private RedisService redisService;

    public void loginUser(String token, SimpleUser simpleUser) {
        Session session = new SimpleSession();

    }

    public void getUser() {

    }
}
