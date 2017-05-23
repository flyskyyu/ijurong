package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.MessageType;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class MessageTypeService extends BaseService<MessageType>{

    /**
     * 查询所有消息类型
     * @param messageType
     * @param page
     * @param rows
     * @return
     */
    public Page<MessageType> findMessageTypesByMessageType(MessageType messageType, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(MessageType.class);
        if(messageType.getName()!=null&&messageType.getName()!="") {
            example.createCriteria().andLike("name", "%" + messageType.getName() + "%");
        }
        List<MessageType> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<MessageType>(count, list);
    }

    public MessageType findMessageTypeById(int id) {
        MessageType messageType=new MessageType();
        messageType.setId(id);
        return  mapper.selectOne(messageType);
    }


    /**
     * 根据名称查询消息类型
     * @param name
     * @return
     */
    public long findMessageTypesByName(String name)
    {
        MessageType messageType=new MessageType();
        messageType.setName(name);
        return mapper.selectCount(messageType);
    }

    /**
     * 添加消息类型
     * @param messageType
     */
    public void insertMessageType(MessageType messageType)
    {
        mapper.insert(messageType);
    }

    /**
     * 更新消息类型
     * @param messageType
     */
    public void updateMessageType(MessageType messageType)
    {
        mapper.updateByPrimaryKeySelective(messageType);
    }

    /**
     * 删除消息类型
     * @param id
     */
    public void deleteMessageType(int id)
    {
        MessageType messageType=new MessageType();
        messageType.setId(id);
        mapper.delete(messageType);
    }

}
