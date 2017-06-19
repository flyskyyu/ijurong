package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.CarMapper;
import com.party.ijurong.pojo.Car;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Cloud on 2017/5/25.
 */
@Service
public class CarService extends BaseService<Car> {
    @Autowired
    private CarMapper carMapper;

    public PageInfo<Car> queryByCar(Car car, int page, int rows) {
        Example example = new Example(Car.class);
        Example.Criteria criteria = example.createCriteria();
        String carNum = car.getCarNum();
        if(carNum != null && StringUtils.isNotEmpty(carNum.trim())) {
            criteria.andLike("carNum", "%" + carNum+ "%");
        }
        if(car.getPartyBranchId() != null) {
            criteria.andEqualTo("partyBranchId", car.getPartyBranchId());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<Car> objs = carMapper.selectByExample(example);
        return new PageInfo<>(objs);
    }

    public PageInfo<Car> queryIsUsingByCar(Car car, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Car> list = carMapper.queryIsUsingByCar(car);
        return new PageInfo<>(list);
    }
}
