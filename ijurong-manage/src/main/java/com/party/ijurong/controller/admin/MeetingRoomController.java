package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.MeetingRoom;
import com.party.ijurong.service.MeetingRoomService;
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
@RequestMapping("admin/meetingRoom")
public class MeetingRoomController {
    @Autowired
    private MeetingRoomService roomService;
    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(MeetingRoom obj, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(obj.getPartyBranchId() == null) {
            SimpleUser user = shiroService.getUser();
            obj.setPartyBranchId(user.getBranchInfos().get(0).getId());
        }
        PageInfo<MeetingRoom> pageInfo = roomService.queryByRoom(obj, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "listByQ")
    @ResponseBody
    public Page listByQ(String q, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MeetingRoom room = new MeetingRoom();
        room.setName(q);
        SimpleUser user = shiroService.getUser();
        room.setPartyBranchId(user.getBranchInfos().get(0).getId());
        PageInfo<MeetingRoom> pageInfo = roomService.queryByRoom(room, page ,rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(MeetingRoom obj) {
        roomService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(MeetingRoom obj) {
        obj.setId(null);
        roomService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        roomService.deleteById(id);
        return "success";
    }
}
