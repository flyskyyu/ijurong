package com.party.ijurong.dto;

import com.party.ijurong.pojo.StaffRole;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
public class StaffRoleDto extends StaffRole {
    private String staffName;
    private String roleName;
    private String roleCode;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
