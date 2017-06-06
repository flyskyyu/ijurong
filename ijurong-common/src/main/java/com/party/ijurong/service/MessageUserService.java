package com.party.ijurong.service;

import com.party.ijurong.pojo.MessageUser;
import org.springframework.stereotype.Service;

/**
 * Created by yu on 2017/6/6.
 */
@Service
public class MessageUserService extends BaseService<MessageUser>{

    /**
     * 更新消息
     * @param message
     */
    public void updateMessageUser(MessageUser message)
    {
        mapper.updateByPrimaryKeySelective(message);
    }

}
