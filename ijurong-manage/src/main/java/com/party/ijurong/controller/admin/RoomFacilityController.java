package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.pojo.RoomFacility;
import com.party.ijurong.service.RoomFacilityService;
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
@RequestMapping("admin/roomFacility")
public class RoomFacilityController {
    @Autowired
    private RoomFacilityService facilityService;
    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(RoomFacility facility, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<RoomFacility> pageInfo = facilityService.queryByFacility(facility, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "listByQ")
    @ResponseBody
    public Page listByQ(String q, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        RoomFacility facility = new RoomFacility();
        facility.setName(q);
        SimpleUser user = shiroService.getUser();
        facility.setPartyBranchId(user.getBranchInfos().get(0).getId());
        PageInfo<RoomFacility> pageInfo = facilityService.queryByFacility(facility, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(RoomFacility obj) {
        facilityService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(RoomFacility obj) {
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
