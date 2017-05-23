package com.party.ijurong.mapper;

import com.party.ijurong.dto.HardMemberApplyDto;
import com.party.ijurong.pojo.HardMemberApply;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HardMemberApplyMapper extends Mapper<HardMemberApply> {
    List<HardMemberApplyDto> queryApplyDtoList(HardMemberApplyDto dto);
}