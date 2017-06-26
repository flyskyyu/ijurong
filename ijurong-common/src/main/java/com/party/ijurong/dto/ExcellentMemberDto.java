package com.party.ijurong.dto;

import com.party.ijurong.pojo.ExcellentMember;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
public class ExcellentMemberDto extends ExcellentMember {
    private String staffName;
    private Byte sex;
    private String phoneNumber;
    private String headChar;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeadChar() {
        return headChar;
    }

    public void setHeadChar(String headChar) {
        this.headChar = headChar;
    }
}
