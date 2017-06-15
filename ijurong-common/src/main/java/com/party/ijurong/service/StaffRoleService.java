package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.StaffRoleDto;
import com.party.ijurong.mapper.StaffRoleMapper;
import com.party.ijurong.pojo.StaffRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
@Service
public class StaffRoleService extends BaseService<StaffRole> {
    @Autowired
    private StaffRoleMapper staffRoleMapper;

    public PageInfo<StaffRoleDto> queryByDto(StaffRoleDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<StaffRoleDto> staffRoles = staffRoleMapper.queryByDto(dto);
        return new PageInfo<>(staffRoles);
    }
}
