package com.party.ijurong.service;

import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.PartyBranchInfo;
import com.party.ijurong.pojo.Staff;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Cloud on 2017/2/10.
 */
@Service
public class ShiroService {
    public final static int LOGIN_OK = 1;
    public final static int LOGIN_UNKNOWN_ACCOUNT = 2;
    public final static int LOGIN_OTHER_ERROR = 3;
    public final static String USER_KEY = "USER_KEY";

    @Autowired
    private PartyBranchInfoService branchInfoService;
    @Autowired
    private StaffService staffService;


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

    public SimpleUser getUser() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Integer userId = (Integer)subject.getPrincipal();
        if(session == null || userId == null) return null;
        SimpleUser user = (SimpleUser)session.getAttribute(USER_KEY);
        if(user == null) {
            Staff staff = staffService.queryById(userId);
            user = new SimpleUser(staff);
            PartyBranchInfo info = branchInfoService.queryById(staff.getPartyBranchId());
            user.setPartyBranchName(info.getOrganizationName());
            List<PartyBranchInfo> infos = branchInfoService.findSelfAndChildren(user.getPartyBranchId());
            user.setBranchInfos(infos);
            session.setAttribute(USER_KEY, user);
        }
        return user;
    }
}
