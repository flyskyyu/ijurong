package com.party.ijurong.mapper;

import com.party.ijurong.common.BaseMapper;
import com.party.ijurong.pojo.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface StaffMapper extends BaseMapper<Staff> {

    long updateIntegralByUserId(@Param("filter") Map<String, Object> filter);
}