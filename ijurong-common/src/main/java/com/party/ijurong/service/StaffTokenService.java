package com.party.ijurong.service;

import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.StaffTokenDto;
import com.party.ijurong.mapper.StaffTokenMapper;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.pojo.StaffToken;
import com.party.ijurong.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/28 0028.
 */
@Service
public class StaffTokenService extends BaseService<StaffToken> {
    @Autowired
    private StaffTokenMapper tokenMapper;
    @Autowired
    private MobileShiroService shiroService;

    public StaffTokenDto queryByTokenDto(StaffTokenDto dto) {
        return tokenMapper.queryByTokenDto(dto);
    }

    public StaffTokenDto queryByToken(String token) {
        StaffTokenDto dto = new StaffTokenDto();
        dto.setToken(token);
        return tokenMapper.queryByTokenDto(dto);
    }

    public StaffToken queryByStaffId(Integer id) {
        StaffToken token = new StaffToken();
        token.setStaffId(id);
        List<StaffToken> list = tokenMapper.select(token);
        if(list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public String saveStaffToken(Staff dbStaff, String deviceNumber, String ip) {
        StaffToken staffToken = queryByStaffId(dbStaff.getStaffId());
        /*if(staffToken != null && !deviceNumber.equals(staffToken.getDeviceNumber())) {
            //手机已经更换
            return null;
        }*/
        if(staffToken == null) {
            staffToken = new StaffToken();
        }
        String token = RandomUtils.generateToken(dbStaff);
        staffToken.setToken(token);
        staffToken.setStaffId(dbStaff.getStaffId());
        staffToken.setLoginTime(new Date());
        staffToken.setIp(ip);
        staffToken.setDeviceNumber(deviceNumber);
        if(staffToken.getId() == null) {
            tokenMapper.insert(staffToken);
        } else {
            tokenMapper.updateByPrimaryKeySelective(staffToken);
        }
        SimpleUser simpleUser = new SimpleUser(dbStaff);
        simpleUser.setToken(token);
        shiroService.saveUserInSession(simpleUser);
        return token;
    }


    public List<StaffToken> getStaffTokenByStaffId( List<Integer> list)
    {

        Example example = new Example(StaffToken.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("staffId",list);
        List<StaffToken> staffs = tokenMapper.selectByExample(example);
        return staffs;
    }
}
