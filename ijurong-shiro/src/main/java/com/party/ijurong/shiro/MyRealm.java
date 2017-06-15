package com.party.ijurong.shiro;

import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Permission;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.PermissionService;
import com.party.ijurong.service.RedisService;
import com.party.ijurong.service.ShiroService;
import com.party.ijurong.service.StaffService;
import org.apache.http.util.TextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by Cloud on 2017/2/10.
 */
public class MyRealm extends AuthorizingRealm{
    @Autowired
    private StaffService staffService;
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private PermissionService permissionService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleUser user = shiroService.getUser();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String key = "MyPermissions";
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        List<Permission> permissions = null;
        permissions = (List)session.getAttribute(key);
        if(permissions == null) {
            permissions = permissionService.queryAllPermissions(user.getUserId());
            session.setAttribute(key, permissions);
        }
        for(Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionCode());
        }
        return info;
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
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getStaffId(), password, this.getClass().getSimpleName());
        return info;
    }
}
