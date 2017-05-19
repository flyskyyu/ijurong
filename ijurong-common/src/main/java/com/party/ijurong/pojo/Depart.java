package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Depart {
    @Id
    @Column(name = "depart_id")
    private Integer departId;

    @Column(name = "depart_code")
    private String departCode;

    @Column(name = "depart_name")
    private String departName;

    @Column(name = "depart_kind_id")
    private Integer departKindId;

    private Byte validflag;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "order_no")
    private Integer orderNo;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_staff_id")
    private Integer updateStaffId;

    @Column(name = "update_depart_id")
    private Integer updateDepartId;

    /**
     * @return depart_id
     */
    public Integer getDepartId() {
        return departId;
    }

    /**
     * @param departId
     */
    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    /**
     * @return depart_code
     */
    public String getDepartCode() {
        return departCode;
    }

    /**
     * @param departCode
     */
    public void setDepartCode(String departCode) {
        this.departCode = departCode == null ? null : departCode.trim();
    }

    /**
     * @return depart_name
     */
    public String getDepartName() {
        return departName;
    }

    /**
     * @param departName
     */
    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    /**
     * @return depart_kind_id
     */
    public Integer getDepartKindId() {
        return departKindId;
    }

    /**
     * @param departKindId
     */
    public void setDepartKindId(Integer departKindId) {
        this.departKindId = departKindId;
    }

    /**
     * @return validflag
     */
    public Byte getValidflag() {
        return validflag;
    }

    /**
     * @param validflag
     */
    public void setValidflag(Byte validflag) {
        this.validflag = validflag;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return order_no
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return update_staff_id
     */
    public Integer getUpdateStaffId() {
        return updateStaffId;
    }

    /**
     * @param updateStaffId
     */
    public void setUpdateStaffId(Integer updateStaffId) {
        this.updateStaffId = updateStaffId;
    }

    /**
     * @return update_depart_id
     */
    public Integer getUpdateDepartId() {
        return updateDepartId;
    }

    /**
     * @param updateDepartId
     */
    public void setUpdateDepartId(Integer updateDepartId) {
        this.updateDepartId = updateDepartId;
    }
}