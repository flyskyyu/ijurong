package com.party.ijurong.mapper;

import com.party.ijurong.dto.ReplyDto;
import com.party.ijurong.pojo.Reply;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ReplyMapper extends Mapper<Reply> {
    void increaseReplyNum(Integer id);

    void increaseLikeNum(Integer id);

    List<ReplyDto> queryByReplyDto(ReplyDto dto);
}