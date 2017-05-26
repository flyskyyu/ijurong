package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.mapper.CarOrderMapper;
import com.party.ijurong.pojo.CarOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cloud on 2017/5/25.
 */
@Service
public class CarOrderService extends BaseService<CarOrder> {
    @Autowired
    private CarOrderMapper carOrderMapper;

    public PageInfo<CarOrderDto> queryCarOrderDtoList(CarOrderDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<CarOrderDto> dtos = carOrderMapper.queryByCarOrderDto(dto);
        return new PageInfo<>(dtos);
    }

    public void apply(CarOrder apply) {

    }
}
