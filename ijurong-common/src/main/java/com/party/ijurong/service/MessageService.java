package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Message;
import com.party.ijurong.pojo.MessageType;
import com.party.ijurong.pojo.Volunteer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class MessageService extends BaseService<Message>{

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
        Message message=new Message();
        message.setId(id);
        mapper.delete(message);
    }

}
