package com.party.ijurong.mapper;

import com.party.ijurong.pojo.Permission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {
    List<Permission> queryAllPermissions(Integer staffId);
}