package com.party.ijurong.service;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.pojo.CarOrder;
import org.springframework.stereotype.Service;

/**
 * Created by Cloud on 2017/5/25.
 */
@Service
public class CarOrderService extends BaseService<CarOrder> {
    public PageInfo<CarOrderDto> queryCarOrderDtoList(CarOrderDto dto, int page, int rows) {
        return null;
    }

    public void apply(CarOrderDto apply) {

    }
}
