package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.CombotreeResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.PartyBranchInfoService;
import com.party.ijurong.service.ShiroService;
import com.party.ijurong.service.StaffService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Cloud on 2017/5/25.
 */
@Controller
@RequestMapping("admin/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private PartyBranchInfoService branchInfoService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<Staff> list(Staff staff, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        SimpleUser user = shiroService.getUser();
        staff.setPartyBranchId(user.getPartyBranchId());
        PageInfo<Staff> pageInfo = staffService.queryByStaff(staff, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "changePassword")
    @ResponseBody
    public String changePassword(String password, String oldPassword) {
        SimpleUser user = shiroService.getUser();
        Staff staff = staffService.queryById(user.getUserId());
        if(!staff.getPassword().equals(DigestUtils.md5Hex(oldPassword))) {
            return "password_recorrect";
        }
        String md5Password = DigestUtils.md5Hex(password);
        staff.setPassword(md5Password);
        staffService.updateSelective(staff);
        return  "success";
    }

    @RequestMapping(value = "listByQ")
    @ResponseBody
    public Page<Staff> listByQ(String q, Integer branchId, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        Staff staff = new Staff();
        staff.setStaffName(q);
        SimpleUser user = shiroService.getUser();
        if(branchId == null) {

            staff.setPartyBranchId(user.getPartyBranchId());
        } else {
            List<CombotreeResult> results = branchInfoService.findTreeMenuListById(user.getPartyBranchId());
            staff.setBranchInfos(results);
        }
        PageInfo<Staff> pageInfo = staffService.queryByStaff(staff, page, rows);
        return  new Page(pageInfo);
    }
}
