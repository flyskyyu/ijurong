package com.party.ijurong.dto;

import com.party.ijurong.pojo.CarOrder;

/**
 * Created by Cloud on 2017/5/26.
 */
public class CarOrderDto extends CarOrder {
    private String staffName;
    private String carNum;
    private Integer partyBranchId;
    private String phoneNumber;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
