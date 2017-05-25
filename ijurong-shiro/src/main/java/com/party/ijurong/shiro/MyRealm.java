package com.party.ijurong.shiro;

import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.StaffService;
import org.apache.http.util.TextUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Cloud on 2017/2/10.
 */
public class MyRealm extends AuthorizingRealm{
    @Autowired
    private StaffService staffService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleUser user = (SimpleUser)principalCollection.getPrimaryPrincipal();
        return null;
    }

    //登陆认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if(TextUtils.isBlank(token.getUsername())) return null;
        Staff user = staffService.queryByEmailOrPhoneNumber(token.getUsername());
        if(user == null) {
            return null; //用户不存在
        }
        String password = user.getPassword();
        SimpleUser simpleUser = new SimpleUser(user);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(simpleUser, password, this.getClass().getSimpleName());
        return info;
    }
}
