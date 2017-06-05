package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.AppShufflingPic;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.pojo.Message;
import com.party.ijurong.pojo.MessageType;
import com.party.ijurong.service.CarService;
import com.party.ijurong.service.MessageService;
import com.party.ijurong.service.MessageTypeService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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



    @RequestMapping(value = "getType")
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


    @RequestMapping(value = "add", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public MobileResult addMessage(HttpServletRequest httpServletRequest, @ModelAttribute Message message)
    {
        MobileResult result = new MobileResult();
        try {
            SimpleUser user = shiroService.getUser();
            message.setCreateTime(new Date());
            message.setCreateUserId(user.getUserId());
            message.setId(0);
            message.setIsPost(0);
            messageService.insertMessage(message);
            result.setCode(200);
            result.setMsg("提交成功");
        }catch (Exception e)
        {
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }



}
