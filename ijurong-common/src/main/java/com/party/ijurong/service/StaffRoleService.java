package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.StaffRoleDto;
import com.party.ijurong.mapper.StaffRoleMapper;
import com.party.ijurong.pojo.StaffRole;
import org.apache.commons.lang3.StringUtils;
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

    public void save(Integer staffId, String roles) {
        if(StringUtils.isEmpty(roles)) return;
        StaffRole record = new StaffRole();
        record.setStaffId(staffId);
        staffRoleMapper.delete(record);
        String[] roleIds = roles.split(",");
        for(String roleId : roleIds) {
            StaffRole staffRole = new StaffRoleDto();
            staffRole.setStaffId(staffId);
            staffRole.setRoleId(Integer.parseInt(roleId));
            staffRoleMapper.insertSelective(staffRole);
        }
    }

    public void update(Integer staffId, String roles) {
        if(StringUtils.isEmpty(roles)) return;
        String[] roleIds = roles.split(",");
        StaffRole record = new StaffRole();
        record.setStaffId(staffId);
        staffRoleMapper.delete(record);
        for(String roleId : roleIds) {
            StaffRole staffRole = new StaffRoleDto();
            staffRole.setStaffId(staffId);
            staffRole.setRoleId(Integer.parseInt(roleId));
            staffRoleMapper.insertSelective(staffRole);
        }
    }
}
