package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.dto.MeetingRoomOrderDto;
import com.party.ijurong.pojo.CarOrder;
import com.party.ijurong.pojo.MeetingRoomOrder;
import com.party.ijurong.service.CarOrderService;
import com.party.ijurong.service.MeetingRoomOrderService;
import com.party.ijurong.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller
@RequestMapping("admin/meetingRoomOrder")
public class MeetingRoomOrderController {
    @Autowired
    private MeetingRoomOrderService roomOrderService;
    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(MeetingRoomOrderDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(dto.getPartyBranchId() == null) {
            SimpleUser user = shiroService.getUser();
            dto.setPartyBranchId(user.getBranchInfos().get(0).getId());
        }
        PageInfo<MeetingRoomOrderDto> pageInfo = roomOrderService.queryRoomOrderDtoList(dto, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(MeetingRoomOrder obj) {
        roomOrderService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(MeetingRoomOrder obj) {
        obj.setId(null);
        obj.setIsAgree(null);
        roomOrderService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        roomOrderService.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "reply")
    @ResponseBody
    public String reply(MeetingRoomOrder apply) {
        int result = roomOrderService.apply(apply);
        if(result == CarOrderService.RESERVATION_ALREADY) {
            return "reservation_already";
        }
        return "success";
    }
}
