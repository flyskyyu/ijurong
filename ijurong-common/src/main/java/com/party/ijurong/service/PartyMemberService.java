package com.party.ijurong.service;

import com.party.ijurong.mapper.PartyMemberMapper;
import com.party.ijurong.mapper.StaffMapper;
import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.utils.PinyinUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cloud on 2017/5/20 0020.
 */
@Service
public class PartyMemberService extends BaseService<PartyMember> {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PartyMemberMapper memberMapper;

    public void saveMember(Staff staff, PartyMember partyMember) {
        staff.setStaffId(null);
        staff.setIntegral(0);
        String md5Password = DigestUtils.md5Hex(staff.getPassword());
        staff.setPassword(md5Password);
        if(StringUtils.isNotBlank(staff.getStaffName())) {
            String headChar = PinyinUtils.getPinYinHeadChar(staff.getStaffName().trim().substring(0, 1));
            staff.setHeadChar(headChar.toLowerCase());
        }
        staffMapper.insertSelective(staff);
        partyMember.setUserId(staff.getStaffId());
        memberMapper.insertSelective(partyMember);
    }

    public void updateMember(Staff staff, PartyMember partyMember) {
        if(StringUtils.isNotBlank(staff.getStaffName())) {
            String headChar = PinyinUtils.getPinYinHeadChar(staff.getStaffName().trim().substring(0, 1));
            staff.setHeadChar(headChar.toLowerCase());
        }
        staffMapper.updateByPrimaryKeySelective(staff);
        partyMember.setUserId(staff.getStaffId());
        memberMapper.updateByPrimaryKeySelective(partyMember);
    }
}
