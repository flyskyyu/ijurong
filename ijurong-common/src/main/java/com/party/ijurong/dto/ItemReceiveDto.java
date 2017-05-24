package com.party.ijurong.dto;

import com.party.ijurong.pojo.ItemReceive;

/**
 * Created by Cloud on 2017/5/24.
 */
public class ItemReceiveDto extends ItemReceive {
    private String staffName;
    private String itemName;
    private String phoneNumber;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
