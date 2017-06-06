package com.party.ijurong.mapper;

import com.party.ijurong.dto.MessageDto;
import com.party.ijurong.pojo.Message;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MessageMapper extends Mapper<Message> {

    List<MessageDto> getMessageByUserId(@Param("userId") int userId);
}