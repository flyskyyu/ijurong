package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.RoomFacility;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.RoomFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
@Controller
@RequestMapping("mobile/roomFacility")
public class MobileRoomFacilityController {
    @Autowired
    private RoomFacilityService facilityService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(RoomFacility obj, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(obj.getPartyBranchId() == null) {
            SimpleUser user = shiroService.getUser();
            obj.setPartyBranchId(user.getPartyBranchId());
        }
        PageInfo<RoomFacility> pageInfo = facilityService.queryByFacility(obj, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }
}
