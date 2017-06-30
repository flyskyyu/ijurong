package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.MessageDto;
import com.party.ijurong.mapper.MessageMapper;
import com.party.ijurong.mapper.MessageSysMapper;
import com.party.ijurong.pojo.*;
import com.party.ijurong.utils.JpushClientUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class MessageService extends BaseService<Message>{

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageSysMapper messageSysMapper;

    @Autowired
    private StaffTokenService staffTokenService;

    public PageInfo<MessageDto> getMessageByUserId(int userId, int page, int rows)
    {
        PageHelper.startPage(page, rows);
        List<MessageDto> dtos = messageMapper.getMessageByUserId(userId);
        return new PageInfo<>(dtos);
    }

    public Message getMessageById(int id)
    {
        return messageMapper.selectByPrimaryKey(id);
    }
    /**
     * 查询所有消息
     * @param message
     * @param page
     * @param rows
     * @return
     */
    public Page<Message> findMessagesByMessage(Message message, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(Message.class);
        if(message.getTitle()!=null&&message.getTitle()!="") {
            example.createCriteria().andLike("title", "%" + message.getTitle() + "%");
        }
        example.setOrderByClause("create_time DESC");
        List<Message> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<Message>(count, list);
    }

    public Message findMessageById(int id) {
        Example example = new Example(Message.class);
        example.createCriteria().andEqualTo("id", id);
        return  mapper.selectByExample(example).get(0);
    }

    /**
     * 添加消息
     * @param message
     */
    public void insertMessage(Message message)
    {
        mapper.insert(message);
    }

    /**
     * 更新消息
     * @param message
     */
    public void updateMessage(Message message)
    {
        mapper.updateByPrimaryKeySelective(message);
    }

    /**
     * 删除消息
     * @param id
     */
    public void deleteMessage(int id)
    {
        mapper.deleteByPrimaryKey(id);
    }


    //发送系统消息
    /**
     * functionContent如下
     //    通知AAA 组织活动AAB 优秀党员AAC
     //    互动资源AAD 志愿大厅AAE 问卷调查AAF
     //    专题讨论AAG 积分商城ABA 消息DAA 党费缴纳DAB
     //    帐号被顶DAC 会议室BAA 物品管理BAB 车辆管理BAC
     *
     * origin就是ConstantOrigin
     *
     * messageSys不需要给值以上2个参数 需要title，messagecontent，userid
     */
    public void sendSystemMessage(MessageSys messageSys,String functionContent,int origin) throws Exception
    {
        messageSys.setCreateTime(new Date());
        messageSys.setFunctionContent(functionContent);
        messageSys.setIsRead(0);
        messageSys.setType(origin);
        messageSysMapper.insertSelective(messageSys);
        //极光推送
        StaffToken staffToken=staffTokenService.queryByStaffId(messageSys.getUserId());
        String deviceNumber=staffToken.getDeviceNumber();
        JpushClientUtil.sendToRegistrationId(deviceNumber, messageSys.getTitle(), messageSys.getTitle(), messageSys.getNewsContent(), messageSys.getFunctionContent());
    }


    public Page<MessageSys> getMessageSysByUserId(int isRead,int userId, int page, int rows)
    {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(MessageSys.class);
        example.createCriteria().andEqualTo("userId",userId);
        example.createCriteria().andEqualTo("isRead",isRead);
        example.setOrderByClause("create_time DESC");
        List<MessageSys> list =messageSysMapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = messageSysMapper.selectCountByExample(example);
        return new Page<MessageSys>(count, list);
    }

    public void updateMessageSys(MessageSys messageSys)
    {
        messageSysMapper.updateByPrimaryKeySelective(messageSys);
    }

}
