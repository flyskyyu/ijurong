package com.party.ijurong.bean;

import com.party.ijurong.pojo.PartyBranchInfo;
import com.party.ijurong.pojo.Staff;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Cloud on 2017/2/22.
 */
public class SimpleUser implements Serializable{
    private Integer userId;
    private String userName;
    private String phone;
    private Integer partyBranchId;
    private String partyBranchName;
    private String token;
    private List<PartyBranchInfo> branchInfos;

    public SimpleUser() {

    }

    public SimpleUser(Staff staff) {
        this.userId = staff.getStaffId();
        this.userName = staff.getStaffName();
        this.partyBranchId = staff.getPartyBranchId();
        this.phone = staff.getPhoneNumber();
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

    public List<PartyBranchInfo> getBranchInfos() {
        return branchInfos;
    }

    public void setBranchInfos(List<PartyBranchInfo> branchInfos) {
        this.branchInfos = branchInfos;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPartyBranchName() {
        return partyBranchName;
    }

    public void setPartyBranchName(String partyBranchName) {
        this.partyBranchName = partyBranchName;
    }
}
