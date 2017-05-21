package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.StaffMapper;
import com.party.ijurong.pojo.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */
@Service
public class StaffService extends BaseService<Staff> {
    @Autowired
    private StaffMapper staffMapper;

    public PageInfo<Staff> queryByStaff(Staff staff, int page, int rows) {
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        if(staff.getStaffName() != null && StringUtils.isNotEmpty(staff.getStaffName().trim())) {
            criteria.andLike("staffName", "%" + staff.getStaffName() + "%");
        }
        PageHelper.startPage(page, rows);
        List<Staff> staffs = staffMapper.selectByExample(example);
        return new PageInfo<>(staffs);
    }
}
