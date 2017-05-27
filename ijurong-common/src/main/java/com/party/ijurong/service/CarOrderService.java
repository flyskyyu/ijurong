package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.mapper.CarOrderMapper;
import com.party.ijurong.pojo.CarOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Cloud on 2017/5/25.
 */
@Service
public class CarOrderService extends BaseService<CarOrder> {
    public final static int OK = 1;
    public final static int RESERVATION_ALREADY = 2; //已经预约
    @Autowired
    private CarOrderMapper carOrderMapper;

    public PageInfo<CarOrderDto> queryCarOrderDtoList(CarOrderDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<CarOrderDto> dtos = carOrderMapper.queryByCarOrderDto(dto);
        return new PageInfo<>(dtos);
    }

    public int apply(CarOrder apply) {
        //同意的场合判断车辆是否已经预约
        if(apply.getIsAgree() == 1) {

            if(carOrderMapper.queryOrdeCarCount(apply) > 0) {
                return RESERVATION_ALREADY;
            }
        }

        apply.setStaffId(null);
        carOrderMapper.updateByPrimaryKeySelective(apply);
        return OK;
    }
}
