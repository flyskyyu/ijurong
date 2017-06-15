package com.party.ijurong.mapper;

import com.party.ijurong.dto.StaffRoleDto;
import com.party.ijurong.pojo.StaffRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StaffRoleMapper extends Mapper<StaffRole> {
    List<StaffRoleDto> queryByDto(StaffRoleDto dto);
}