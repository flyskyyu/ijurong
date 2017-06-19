package com.party.ijurong.mapper;

import com.party.ijurong.pojo.MeetingRoom;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MeetingRoomMapper extends Mapper<MeetingRoom> {
    List<MeetingRoom> queryIsUsingByRoom(MeetingRoom room);
}