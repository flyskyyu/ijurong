package com.party.ijurong.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.CalendarDto;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.dto.MeetingRoomOrderDto;
import com.party.ijurong.pojo.CarOrder;
import com.party.ijurong.pojo.MeetingRoomOrder;
import com.party.ijurong.service.CarOrderService;
import com.party.ijurong.service.MeetingRoomOrderService;
import com.party.ijurong.service.MeetingRoomService;
import com.party.ijurong.service.ShiroService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private ObjectMapper objectMapper;

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

    @RequestMapping(value = "calendarList")
    @ResponseBody
    public List calendarList(CalendarDto calendarDto, Integer roomId) throws JsonProcessingException {
        List<CalendarDto> calendarDtos = new ArrayList<>();
        if(roomId == null) return calendarDtos;
        MeetingRoomOrderDto dto = new MeetingRoomOrderDto();
        dto.setRoomId(roomId);
        dto.setStartTime(calendarDto.getStart());
        dto.setEndTime(calendarDto.getEnd());
        dto.setTypeFilter(calendarDto.getTypeFilter());
        PageInfo<MeetingRoomOrderDto> pageInfo = roomOrderService.queryRoomOrderDtoList(dto, 1, 9999);
        for(MeetingRoomOrderDto orderDto : pageInfo.getList()) {
            CalendarDto temp = new CalendarDto();
            temp.setId(orderDto.getId());
            String title = orderDto.getStaffName();
            if(orderDto.getIsAgree() == null) {
                temp.setColor("#49afcd");
                title += "(待批准)\n";
            } else if(orderDto.getIsAgree() == 1) {
                temp.setColor("#51a351");
                title += "(已同意)\n";
            } else if(orderDto.getIsAgree() == 0) {
                temp.setColor("#bd362f");
                title += "(未同意)\n";
            }
            if(StringUtils.isNotEmpty(orderDto.getContent())) {
                title += orderDto.getContent();
            }
            temp.setTitle(title);
            temp.setStart(orderDto.getStartTime());
            temp.setEnd(orderDto.getEndTime());
            temp.setEditable(orderDto.getIsAgree() == null ? true : false);
            temp.setData(objectMapper.writeValueAsString(orderDto));
            calendarDtos.add(temp);
        }
        return  calendarDtos;
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
