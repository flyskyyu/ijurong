package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "staff_role")
public class StaffRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "accredit_time")
    private Date accreditTime;

    @Column(name = "accredit_staff_id")
    private Integer accreditStaffId;

    private String remark;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return staff_id
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return accredit_time
     */
    public Date getAccreditTime() {
        return accreditTime;
    }

    /**
     * @param accreditTime
     */
    public void setAccreditTime(Date accreditTime) {
        this.accreditTime = accreditTime;
    }

    /**
     * @return accredit_staff_id
     */
    public Integer getAccreditStaffId() {
        return accreditStaffId;
    }

    /**
     * @param accreditStaffId
     */
    public void setAccreditStaffId(Integer accreditStaffId) {
        this.accreditStaffId = accreditStaffId;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}