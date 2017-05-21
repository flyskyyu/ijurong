package com.party.ijurong.dto;

import com.party.ijurong.pojo.MemberServe;
import com.party.ijurong.pojo.Staff;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
public class MemberServeDto extends MemberServe{
    private String staffName;
    private MemberServe serve;

    public MemberServe getServe() {
        return serve;
    }

    public void setServe(MemberServe serve) {
        this.serve = serve;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
