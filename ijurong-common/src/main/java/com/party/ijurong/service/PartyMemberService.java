package com.party.ijurong.service;

import com.party.ijurong.mapper.PartyMemberMapper;
import com.party.ijurong.mapper.StaffMapper;
import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.pojo.Staff;
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
        staffMapper.insert(staff);
        partyMember.setUserId(staff.getStaffId());
        memberMapper.insert(partyMember);
    }

    public void updateMember(Staff staff, PartyMember partyMember) {
        staffMapper.updateByPrimaryKeySelective(staff);
        partyMember.setUserId(staff.getStaffId());
        memberMapper.updateByPrimaryKeySelective(partyMember);
    }
}
