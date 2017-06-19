package com.party.ijurong.mapper;

import com.party.ijurong.pojo.Car;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CarMapper extends Mapper<Car> {
    List<Car> queryIsUsingByCar(Car car);
}