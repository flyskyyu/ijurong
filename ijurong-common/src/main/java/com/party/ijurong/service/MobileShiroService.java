package com.party.ijurong.service;

import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.PartyBranchInfo;
import com.party.ijurong.web.UserThreadLocal;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cloud on 2017/5/27.
 */
@Service
public class MobileShiroService {
    private final static String prefix = "MOBILE_SESSION_KEY:";
    public final static String USER_KEY = "MOBILE_USER_KEY";
    @Value("${shiro.expire}")
    public int TOKEN_EXPIRE;
    @Autowired
    private RedisService redisService;
    @Autowired
    private PartyBranchInfoService branchInfoService;

    public void saveUserInSession(SimpleUser simpleUser) {
        Map session = new HashMap();
        if(simpleUser.getBranchInfos() == null) {
            List<PartyBranchInfo> infos = branchInfoService.findSelfAndChildren(simpleUser.getPartyBranchId());
            simpleUser.setBranchInfos(infos);
        }
        session.put(USER_KEY, simpleUser);
        redisService.set(prefix + simpleUser.getToken(), session, TOKEN_EXPIRE);
    }

    public Object getSessionVal(String key) {
        SimpleUser user = getUser();
        Map session = redisService.get(prefix + user.getToken());
        return session.get(key);
    }

    public void setSessionVal(String key, Object val) {
        SimpleUser user = getUser();
        Map session = redisService.get(prefix + user.getToken());
        session.put(key, val);
        redisService.set(prefix + user.getToken(), session);
    }

    public SimpleUser getUser(String token) {
        Map session = redisService.get(prefix + token);
        if(session == null) return null;
        SimpleUser user = (SimpleUser)session.get(USER_KEY);
        if(user != null) {
            //刷新session过期时间
            redisService.expire(prefix + token, TOKEN_EXPIRE);
        }
        return user;
    }

    public SimpleUser getUser() {
        SimpleUser user = UserThreadLocal.get();
        return user;
    }
}
