package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.MeetingRoom;
import com.party.ijurong.service.MeetingRoomService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
@Controller
@RequestMapping("mobile/meetingRoom")
public class MobileMeetingRoomController {
    @Autowired
    private MeetingRoomService roomService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(MeetingRoom room, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(room.getPartyBranchId() == null) {
            SimpleUser user = shiroService.getUser();
            room.setPartyBranchId(user.getPartyBranchId());
        }
        PageInfo<MeetingRoom> pageInfo = roomService.queryByRoom(room, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }
}
