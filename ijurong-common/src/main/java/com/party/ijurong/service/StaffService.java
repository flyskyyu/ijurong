package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.StaffMapper;
import com.party.ijurong.pojo.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(staff.getPartyBranchId() != null) {
            criteria.andEqualTo("partyBranchId", staff.getPartyBranchId());
        }
        PageHelper.startPage(page, rows);
        List<Staff> staffs = staffMapper.selectByExample(example);
        return new PageInfo<>(staffs);
    }

    public Staff queryByEmailOrPhoneNumber(String emailOrPhoneNumber) {
        Example example = new Example(Staff.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("email", emailOrPhoneNumber);
        example.or(example.createCriteria().andEqualTo("phoneNumber", emailOrPhoneNumber));
        List<Staff> staffs = staffMapper.selectByExample(example);
        if(staffs == null || staffs.size() == 0) {
            return null;
        }
        return staffs.get(0);
    }

    /**
     * 加用户积分
     * @param userId 用户id
     * @param integral 积分数
     * @return
     */
    public long updateIntegralByUserId(int userId,int integral)
    {
        try
        {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("userId",userId);
            map.put("integral",integral);
            return staffMapper.updateIntegralByUserId(map);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
