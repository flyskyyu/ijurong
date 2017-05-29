package com.party.ijurong.dto;

import com.party.ijurong.pojo.Staff;
import com.party.ijurong.pojo.StaffToken;

/**
 * Created by Administrator on 2017/5/28 0028.
 */
public class StaffTokenDto extends StaffToken {
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
