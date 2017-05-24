package com.party.ijurong.mapper;

import com.party.ijurong.dto.ItemReceiveDto;
import com.party.ijurong.pojo.ItemReceive;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemReceiveMapper extends Mapper<ItemReceive> {
    List<ItemReceiveDto> queryReceiveDtoList(ItemReceiveDto dto);
}