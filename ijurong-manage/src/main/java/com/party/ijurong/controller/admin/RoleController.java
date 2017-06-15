package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Role;
import com.party.ijurong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/6/15.
 */
@Controller
@RequestMapping("admin/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(Role obj, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<Role> pageInfo = roleService.queryByRole(obj, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "listByQ")
    @ResponseBody
    public Page listByQ(String q, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        Role obj = new Role();
        obj.setRoleName(q);
        PageInfo<Role> pageInfo = roleService.queryByRole(obj, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(Role obj, String addPermissions, String deletePermissions) {
        roleService.updateRole(obj, addPermissions, deletePermissions);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(Role obj, String addPermissions) {
        roleService.addRole(obj, addPermissions);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        roleService.deleteById(id);
        return "success";
    }
}
