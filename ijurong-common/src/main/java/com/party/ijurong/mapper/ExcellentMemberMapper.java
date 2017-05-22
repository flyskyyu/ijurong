package com.party.ijurong.mapper;

import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.pojo.ExcellentMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ExcellentMemberMapper extends Mapper<ExcellentMember> {
    List<ExcellentMemberDto> queryExcellentMemberDtoList(ExcellentMemberDto dto);
}