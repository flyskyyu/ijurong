package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.dto.MeetingRoomOrderDto;
import com.party.ijurong.pojo.CarOrder;
import com.party.ijurong.pojo.MeetingRoom;
import com.party.ijurong.pojo.MeetingRoomOrder;
import com.party.ijurong.service.MeetingRoomOrderService;
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
@RequestMapping("mobile/meetingRoomOrder")
public class MobileMeetingRoomOrderController {
    @Autowired
    private MeetingRoomOrderService roomOrderService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "apply")
    @ResponseBody
    public MobileResult apply(MeetingRoomOrder obj) {
        MobileResult result = new MobileResult();
        if(obj.getRoomId() == null || obj.getStartTime() == null
                || obj.getEndTime() == null) {
            result.setData(400);
            result.setMsg("参数不完整");
            return  result;
        }
        SimpleUser user = shiroService.getUser();
        obj.setId(null);
        obj.setIsAgree(null);
        obj.setReply(null);
        obj.setStaffId(user.getUserId());
        roomOrderService.save(obj);
        result.setCode(200);
        return result;
    }

    @RequestMapping(value = "myApply")
    @ResponseBody
    public MobileResult myApply(MeetingRoomOrderDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        SimpleUser user = shiroService.getUser();
        dto.setStaffId(user.getUserId());
        PageInfo<MeetingRoomOrderDto> pageInfo = roomOrderService.queryRoomOrderDtoList(dto, page, rows);
        result.setCode(200);
        result.setData(pageInfo.getList());
        return result;
    }

    @RequestMapping(value = "allApply")
    @ResponseBody
    public MobileResult allApply(MeetingRoomOrderDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        PageInfo<MeetingRoomOrderDto> pageInfo = roomOrderService.queryRoomOrderDtoList(dto, page, rows);
        result.setCode(200);
        result.setData(pageInfo.getList());
        return result;
    }
}
