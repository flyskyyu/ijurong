package com.party.ijurong.mapper;

import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.pojo.CarOrder;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CarOrderMapper extends Mapper<CarOrder> {
    List<CarOrderDto> queryByCarOrderDto(CarOrderDto dto);

    int queryOrdeCarCount(CarOrder carOrder);
}