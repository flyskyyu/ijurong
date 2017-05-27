package com.party.ijurong.mapper;

import com.party.ijurong.dto.MeetingRoomOrderDto;
import com.party.ijurong.pojo.MeetingRoomOrder;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MeetingRoomOrderMapper extends Mapper<MeetingRoomOrder> {
    List<MeetingRoomOrderDto> queryByRoomOrderDto(MeetingRoomOrderDto dto);

    int queryOrdeRoomCount(MeetingRoomOrder roomOrder);
}