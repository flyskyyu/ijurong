package com.party.ijurong.bean;

import com.party.ijurong.pojo.Staff;

import java.io.Serializable;

/**
 * Created by Cloud on 2017/2/22.
 */
public class SimpleUser implements Serializable{
    private Integer userId;
    private String userName;
    private Integer partyBranchId;

    public SimpleUser() {

    }

    public SimpleUser(Staff staff) {
        this.userId = staff.getStaffId();
        this.userName = staff.getStaffName();
        this.partyBranchId = staff.getPartyBranchId();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
    }
}
