package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.MeetingRoomMapper;
import com.party.ijurong.pojo.MeetingRoom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Cloud on 2017/5/27.
 */
@Service
public class MeetingRoomService extends BaseService<MeetingRoom> {
    @Autowired
    private MeetingRoomMapper roomMapper;

    public PageInfo<MeetingRoom> queryByRoom(MeetingRoom room, int page, int rows) {
        Example example = new Example(MeetingRoom.class);
        Example.Criteria criteria = example.createCriteria();
        String name = room.getName();
        if(name != null && StringUtils.isNotEmpty(name.trim())) {
            criteria.andLike("name", "%" + name+ "%");
        }
        if(room.getPartyBranchId() != null) {
            criteria.andEqualTo("partyBranchId", room.getPartyBranchId());
        }
        PageHelper.startPage(page, rows);
        List<MeetingRoom> rooms = roomMapper.selectByExample(example);
        return new PageInfo<>(rooms);
    }
}
