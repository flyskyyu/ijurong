package com.party.ijurong.mapper;

import com.party.ijurong.dto.StaffTokenDto;
import com.party.ijurong.pojo.StaffToken;
import tk.mybatis.mapper.common.Mapper;

public interface StaffTokenMapper extends Mapper<StaffToken> {
    StaffTokenDto queryByTokenDto(StaffTokenDto dto);
}