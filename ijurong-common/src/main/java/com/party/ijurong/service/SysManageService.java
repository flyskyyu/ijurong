package com.party.ijurong.service;

import com.party.ijurong.mapper.SysManageMapper;
import com.party.ijurong.pojo.SysManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yu on 2017/6/19.
 */
@Service
public class SysManageService extends BaseService<SysManage> {
    @Autowired
    private SysManageMapper sysManageMapper;

    public SysManage findSysManageBySysName(String name) {
        SysManage sysManage=new SysManage();
        sysManage.setSysName(name);
        return  mapper.selectOne(sysManage);
    }
}
