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
    private Integer partyBranchId;
    private String token;
    private List<PartyBranchInfo> branchInfos;

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
}
