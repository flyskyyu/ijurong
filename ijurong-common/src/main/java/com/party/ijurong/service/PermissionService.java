package com.party.ijurong.service;

import com.party.ijurong.mapper.PermissionMapper;
import com.party.ijurong.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Service
public class PermissionService extends BaseService<Permission> {
    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> queryAllPermissions(Integer staffId) {
        return permissionMapper.queryAllPermissions(staffId);
    }
}
