package com.party.ijurong.dto;

import com.party.ijurong.pojo.Activity;

/**
 * Created by Administrator on 2017/6/10 0010.
 */
public class ActivityDto extends Activity{
    private Integer isNew;
    private Integer isHot;
    private Integer staffId;

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}