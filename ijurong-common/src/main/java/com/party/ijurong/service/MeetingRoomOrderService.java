package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.MeetingRoomOrderDto;
import com.party.ijurong.mapper.MeetingRoomOrderMapper;
import com.party.ijurong.pojo.MeetingRoomOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cloud on 2017/5/27.
 */
@Service
public class MeetingRoomOrderService extends BaseService<MeetingRoomOrder> {
    public final static int OK = 1;
    public final static int RESERVATION_ALREADY = 2; //已经预约
    @Autowired
    private MeetingRoomOrderMapper roomOrderMapper;

    public PageInfo<MeetingRoomOrderDto> queryRoomOrderDtoList(MeetingRoomOrderDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MeetingRoomOrderDto> dtos = roomOrderMapper.queryByRoomOrderDto(dto);
        return new PageInfo<>(dtos);
    }

    public int apply(MeetingRoomOrder apply) {
        //同意的场合判断会议室是否已经预约
        /*if(apply.getIsAgree() == 1) {

            if(roomOrderMapper.queryOrdeRoomCount(apply) > 0) {
                return RESERVATION_ALREADY;
            }
        }*/

        apply.setStaffId(null);
        roomOrderMapper.updateByPrimaryKeySelective(apply);
        return OK;
    }
}
