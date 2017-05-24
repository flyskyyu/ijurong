package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Copyright ©, 2016-2056
 * FileName:  AdminController
 *
 * @author CS-711701-00027
 * @version 1.0
 * @Date: 2017/5/16
 * Description:
 * Function List:
 * 1. -------
 * History:
 * maurice 16/02/12 1.0 build this moudle
 */
@RequestMapping("admin/message")
@Controller
public class MessageController {

    @Autowired
    private MessageTypeService messageTypeService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/findMessageTypes", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<MessageType> findMessageTypes(HttpServletRequest httpServletRequest,
                                              @ModelAttribute MessageType messageType, @RequestParam int page, @RequestParam int rows) {
        Page<MessageType> result = messageTypeService.findMessageTypesByMessageType(messageType, page, rows);
        return result;
    }

    @RequestMapping(value = "/findAllMessageTypes", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public List<MessageType> findAllMessageTypes(HttpServletRequest httpServletRequest) {
        Page<MessageType> result = messageTypeService.findMessageTypesByMessageType(new MessageType(), 1, 999);
        return result.getRows();
    }

    @RequestMapping(value = "addMessageType", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addMessageType(HttpServletRequest httpServletRequest, @ModelAttribute MessageType messageType)
    {
        long messageTypeCount= messageTypeService.findMessageTypesByName(messageType.getName());
        if (messageTypeCount==0)
        {
            messageType.setCreateTime(new Date());
            messageType.setCreateUserId(1);//TODO 后期加上人企业
            messageTypeService.insertMessageType(messageType);
            return "success";
        }
        else if(messageTypeCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateMessageType", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateMessageType(HttpServletRequest httpServletRequest, @ModelAttribute MessageType messageType)
    {
        messageTypeService.updateMessageType(messageType);
        return "success";
    }

    @RequestMapping(value = "delectMessageType/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectMessageType(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        messageTypeService.deleteMessageType(id);
        return "success";
    }




    @RequestMapping(value = "/findMessages", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<Message> findMessages(HttpServletRequest httpServletRequest,
                                      @ModelAttribute Message message, @RequestParam int page, @RequestParam int rows) {
        Page<Message> result = messageService.findMessagesByMessage(message, page, rows);
        return result;
    }

    @RequestMapping(value = "addMessage", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addMessage(HttpServletRequest httpServletRequest, @ModelAttribute Message message)
    {
        try {
            message.setCreateTime(new Date());
            message.setCreateUserId(1);//TODO 后期加上人企业
            message.setId(0);
            messageService.insertMessage(message);
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "updateMessage", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateMessage(HttpServletRequest httpServletRequest, @ModelAttribute Message message)
    {
        Message message1=messageService.findMessageById(message.getId());
        if (message1.getIsPost()==0&&message.getIsPost() == 1) {//没有发布过&&现在需要发布
            //插入数据库，用队列？
            //发布信息，调用极光推送
        }
        messageService.updateMessage(message);
        return "success";
    }

    @RequestMapping(value = "delectMessage/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectMessage(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        Message message1=messageService.findMessageById(id);
        if (message1.getIsPost()==1) {//发布中的不能删除
            return "fail";
        }
        messageService.deleteMessage(id);
        return "success";
    }

}
