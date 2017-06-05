package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.AppShufflingPic;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.pojo.MessageType;
import com.party.ijurong.service.CarService;
import com.party.ijurong.service.MessageService;
import com.party.ijurong.service.MessageTypeService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller
@RequestMapping("mobile/message")
public class MobileMessageController {

    @Autowired
    private MobileShiroService shiroService;
    @Autowired
    private MessageTypeService messageTypeService;

    @Autowired
    private MessageService messageService;



    @RequestMapping(value = "getMessageType")
    @ResponseBody
    public MobileResult getMessageType(HttpServletRequest httpServletRequest) {
        MobileResult result = new MobileResult();
        try
        {
            Page<MessageType> page = messageTypeService.findMessageTypesByMessageType(new MessageType(), 1, 999);
            result.setCode(200);
            result.setData(page.getRows());
        }catch (Exception e)
        {
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }
}
