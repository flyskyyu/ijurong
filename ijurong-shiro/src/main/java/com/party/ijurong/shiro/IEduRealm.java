package com.party.ijurong.shiro;

import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.SysUser;
import com.party.ijurong.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Cloud on 2017/2/10.
 */
public class IEduRealm extends AuthorizingRealm{
    @Autowired
    private SysUserService sysUserService;

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
        SysUser user = sysUserService.findByUsername(token.getUsername());
        if(user == null) {
            return null; //用户不存在
        }
        String password = user.getPassword();
        SimpleUser simpleUser = new SimpleUser(user);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(simpleUser, password, this.getClass().getSimpleName());
        return info;
    }
}
