package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.MessageDto;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
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

    @Autowired
    private MessageUserService messageUserService;


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


    @RequestMapping(value = "getMessages")
    @ResponseBody
    public MobileResult getMessages(HttpServletRequest httpServletRequest,@RequestParam(defaultValue = "1")int page
    , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        try
        {
            SimpleUser user = shiroService.getUser();
            PageInfo<MessageDto> pageInfo=messageService.getMessageByUserId(user.getUserId(),page,rows);

            //需要加最热...
            result.setCode(200);
            result.setData(pageInfo.getList());
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }


    @RequestMapping(value = "readMessage")
    @ResponseBody
    public MobileResult readMessage(HttpServletRequest httpServletRequest,@RequestParam int id) {
        MobileResult result = new MobileResult();
        try
        {
            MessageUser messageUser=new MessageUser();
            messageUser.setId(id);
            messageUser.setReadTime(new Date());
            messageUser.setIsRead(1);
            messageUserService.updateMessageUser(messageUser);
            result.setCode(200);

        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }


    @RequestMapping(value = "getSysMessages")
    @ResponseBody
    public MobileResult getSysMessages(HttpServletRequest httpServletRequest,@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        try
        {
            SimpleUser user = shiroService.getUser();
            Page<MessageSys> pages=messageService.getMessageSysByUserId(user.getUserId(), page, rows);

            //需要加最热...
            result.setCode(200);
            result.setData(pages.getRows());
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }


    @RequestMapping(value = "readSysMessages")
    @ResponseBody
    public MobileResult readSysMessages(HttpServletRequest httpServletRequest,@RequestParam int id) {
        MobileResult result = new MobileResult();
        try
        {
            MessageSys messageSys=new MessageSys();
            messageSys.setId(id);
            messageSys.setReadTime(new Date());
            messageSys.setIsRead(1);
            messageService.updateMessageSys(messageSys);
            result.setCode(200);
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }

}
