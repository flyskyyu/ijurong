package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.StaffRoleDto;
import com.party.ijurong.pojo.StaffRole;
import com.party.ijurong.service.StaffRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
@Controller
@RequestMapping("admin/staffRole")
public class StaffRoleController {
    @Autowired
    private StaffRoleService staffRoleService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(StaffRoleDto obj, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<StaffRoleDto> pageInfo = staffRoleService.queryByDto(obj, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(StaffRole obj) {
        staffRoleService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(StaffRole obj) {
        staffRoleService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        staffRoleService.deleteById(id);
        return "success";
    }
}
