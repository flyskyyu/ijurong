package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Item;
import com.party.ijurong.pojo.Permission;
import com.party.ijurong.pojo.Role;
import com.party.ijurong.pojo.RolePermission;
import com.party.ijurong.service.PermissionService;
import com.party.ijurong.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cloud on 2017/6/14.
 */
@Controller
@RequestMapping("admin/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolePermissionService rolePermissionService;


    @RequestMapping(value = "list")
    @ResponseBody
    public Page<Permission> list(Permission obj, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<Permission> pageInfo = permissionService.queryByPermission(obj, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "listAll")
    @ResponseBody
    public Map listAll(Integer roleId) {
        Map map = new HashMap();
        List<Permission> list = permissionService.queryAll();
        map.put("permissions", list);
        if(roleId != null) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            List<RolePermission> rolePermissions = rolePermissionService.queryListByWhere(rolePermission);
            map.put("rolePermissions", rolePermissions);
        }
        return  map;
    }

    @RequestMapping(value = "listByQ")
    @ResponseBody
    public Page<Permission> listByQ(String q, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        Permission obj = new Permission();
        obj.setPermissionName(q);
        PageInfo<Permission> pageInfo = permissionService.queryByPermission(obj, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(Permission obj) {
        permissionService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(Permission obj) {
        permissionService.saveSelective(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        permissionService.deleteById(id);
        return "success";
    }
}
