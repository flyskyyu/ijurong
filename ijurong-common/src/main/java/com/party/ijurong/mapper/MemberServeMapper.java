package com.party.ijurong.mapper;

import com.party.ijurong.dto.MemberServeDto;
import com.party.ijurong.pojo.MemberServe;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberServeMapper extends Mapper<MemberServe> {
    List<MemberServeDto> queryServeDtoList(MemberServeDto dto);
}