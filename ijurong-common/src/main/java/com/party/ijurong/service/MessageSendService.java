package com.party.ijurong.service;

import com.party.ijurong.pojo.Message;
import com.party.ijurong.pojo.MessageUser;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.utils.SpringContextUtil;

import java.util.List;

/**
 * Created by yu on 2017/6/11.
 */
public class MessageSendService extends Thread{

    StaffService staffService=(StaffService) SpringContextUtil.getBean("staffService");

    MessageUserService messageUserService=(MessageUserService) SpringContextUtil.getBean("messageUserService");

    MessageService messageService=(MessageService) SpringContextUtil.getBean("messageService");


    private int id;//通知id
    private String[] str;//机构id
    public MessageSendService(String[] str,int id)
    {
        this.str=str;
        this.id=id;
    }
    @Override
    public void run() {
        List<Staff> list= staffService.getStaffByPartyId(str);//查找所有的用户
        for(int i=0;i<list.size();i++)//先做成这样，有点蛋疼
        {
            int userId=list.get(i).getStaffId();
            MessageUser messageUser=new MessageUser();
            messageUser.setIsRead(0);
            messageUser.setUserId(userId);
            messageUser.setMessageId(id);
            messageUserService.save(messageUser);

            //调用极光推送，暂缺
        }

        //更新通知状态
        Message message=new Message();
        message.setId(id);
        message.setIsPost(2);
        messageService.updateMessage(message);
    }
}
