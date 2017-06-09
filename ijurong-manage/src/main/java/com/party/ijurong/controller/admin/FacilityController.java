package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Facility;
import com.party.ijurong.service.FacilityService;
import com.party.ijurong.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
@Controller
@RequestMapping("admin/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(Facility facility, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<Facility> pageInfo = facilityService.queryByFacility(facility, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "listByQ")
    @ResponseBody
    public Page listByQ(Facility facility, String q, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        facility.setName(q);
        SimpleUser user = shiroService.getUser();
        facility.setPartyBranchId(user.getPartyBranchId());
        PageInfo<Facility> pageInfo = facilityService.queryByFacility(facility, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(Facility obj) {
        facilityService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(Facility obj) {
        obj.setId(null);
        facilityService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        facilityService.deleteById(id);
        return "success";
    }
}
