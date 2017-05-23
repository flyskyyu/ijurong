package com.party.ijurong.dto;

import com.party.ijurong.pojo.HardMemberApply;

import java.util.Date;

/**
 * Created by Cloud on 2017/5/23.
 */
public class HardMemberApplyDto extends HardMemberApply{
    private String staffName;
    private byte sex;
    private Date birthday;
    private String phoneNumber;
    private Integer typeFilter;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTypeFilter() {
        return typeFilter;
    }

    public void setTypeFilter(Integer typeFilter) {
        this.typeFilter = typeFilter;
    }
}
