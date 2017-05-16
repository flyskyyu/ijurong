package com.party.ijurong.service;

import com.party.ijurong.pojo.SysUser;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.stereotype.Service;

/**
 * Created by Cloud on 2017/2/14.
 */
@Service
public class SysUserService extends BaseService<SysUser> {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public SysUser findByUsername(String username) {
        SysUser user = new SysUser();
        user.setUserName(username);
        return mapper.selectOne(user);
    }

    public void insertSysUser(SysUser user)
    {
        mapper.insert(user);
    }
}
