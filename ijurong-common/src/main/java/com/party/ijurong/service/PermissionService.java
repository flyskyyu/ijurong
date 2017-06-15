package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.PermissionMapper;
import com.party.ijurong.pojo.Permission;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    public PageInfo<Permission> queryByPermission(Permission permission, int page, int rows) {
        Example example = new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        String name = permission.getPermissionName();
        if(name != null && StringUtils.isNotEmpty(name.trim())) {
            criteria.andLike("permissionName", "%" + name+ "%");
        }
        example.orderBy("showOrder").asc();
        PageHelper.startPage(page, rows);
        List<Permission> permissions = permissionMapper.selectByExample(example);
        return new PageInfo<>(permissions);
    }

    public List<Permission> queryAllByRoleId(Integer roleId) {
        return permissionMapper.queryAllByRoleId(roleId);
    }
}
