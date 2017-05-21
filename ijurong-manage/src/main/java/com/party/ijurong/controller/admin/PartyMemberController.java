package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.PartyMemberService;
import com.party.ijurong.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Cloud on 2017/5/19.
 */
@Controller
@RequestMapping("/admin/member")
public class PartyMemberController {
    @Autowired
    private PartyMemberService partyMemberService;
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<Staff> list(Staff staff, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<Staff> pageInfo = staffService.queryByStaff(staff, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "getMember")
    @ResponseBody
    public PartyMember getMember(Integer id) {
        return partyMemberService.queryById(id);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(Staff staff, PartyMember partyMember) {
        partyMemberService.updateMember(staff, partyMember);
        return "success";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public String add(Staff staff, PartyMember partyMember) {
        partyMemberService.saveMember(staff, partyMember);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        staffService.deleteById(id);
        return "success";
    }
}
