package com.party.ijurong.mapper;

import com.party.ijurong.dto.ActivityDto;
import com.party.ijurong.pojo.Activity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ActivityMapper extends Mapper<Activity> {
    void increaseReplyNum(Integer id);

    void increaseLikeNum(Integer id);

    void increaseClickAmount(Integer id);

    List<ActivityDto> queryByDto(ActivityDto dto);

    int getIntegral(Integer id);
}