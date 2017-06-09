package com.party.ijurong.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.party.ijurong.pojo.MeetingRoomOrder;

/**
 * Created by Cloud on 2017/5/27.
 */
public class MeetingRoomOrderDto extends MeetingRoomOrder {
    private String staffName;
    private String phoneNumber;
    private String name;
    private Integer partyBranchId;
    @JsonIgnore
    private int typeFilter;
    @JsonIgnore
    private int orderType;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
    }

    public int getTypeFilter() {
        return typeFilter;
    }

    public void setTypeFilter(int typeFilter) {
        this.typeFilter = typeFilter;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
}
