package com.party.ijurong.bean;

import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.pojo.Staff;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
public class MemberDto {
    private Staff staff;
    private PartyMember member;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public PartyMember getMember() {
        return member;
    }

    public void setMember(PartyMember member) {
        this.member = member;
    }
}
