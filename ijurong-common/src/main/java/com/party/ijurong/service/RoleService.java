package com.party.ijurong.service;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.RoleMapper;
import com.party.ijurong.mapper.RolePermissionMapper;
import com.party.ijurong.pojo.Role;
import com.party.ijurong.pojo.RolePermission;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cloud on 2017/6/15.
 */
@Service
public class RoleService extends BaseService<Role> {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    public PageInfo<Role> queryByRole(Role role, int page, int rows) {
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        String name = role.getRoleName();
        if(name != null && StringUtils.isNotEmpty(name.trim())) {
            criteria.andLike("roleName", "%" + name+ "%");
        }
        example.orderBy("id").desc();
        List<Role> roles = roleMapper.selectByExample(example);
        return new PageInfo<>(roles);
    }

    public void addRole(Role role, String addPermissions) {
        roleMapper.insertSelective(role);
        insertPermissions(role.getId(), addPermissions);
    }

    public void updateRole(Role role, String addPermissions, String deletePermissions) {
        roleMapper.updateByPrimaryKeySelective(role);
        deletePermissions(role.getId(), deletePermissions);
        insertPermissions(role.getId(), addPermissions);
    }

    private void insertPermissions(Integer roleId, String addPermissions) {
        if(StringUtils.isEmpty(addPermissions)) return;
        String[] permissions = addPermissions.split(",");
        for(String permission : permissions) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(Integer.parseInt(permission));
            rolePermissionMapper.insertSelective(rolePermission);
        }
    }

    private void deletePermissions(Integer roleId, String deletePermissions) {
        if(StringUtils.isEmpty(deletePermissions)) return;
        String[] permissions = deletePermissions.split(",");
        Example example = new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        criteria.andIn("permissionId", Arrays.asList(permissions));
        rolePermissionMapper.deleteByExample(example);
    }
}
