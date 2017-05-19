package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Departkind {
    @Id
    @Column(name = "depart_kind_id")
    private Integer departKindId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "depart_kind_code")
    private Short departKindCode;

    @Column(name = "depart_kind")
    private String departKind;

    private String rremark;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_staff_id")
    private Integer updateStaffId;

    @Column(name = "update_depart_id")
    private Integer updateDepartId;

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
     * @return product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return depart_kind_code
     */
    public Short getDepartKindCode() {
        return departKindCode;
    }

    /**
     * @param departKindCode
     */
    public void setDepartKindCode(Short departKindCode) {
        this.departKindCode = departKindCode;
    }

    /**
     * @return depart_kind
     */
    public String getDepartKind() {
        return departKind;
    }

    /**
     * @param departKind
     */
    public void setDepartKind(String departKind) {
        this.departKind = departKind == null ? null : departKind.trim();
    }

    /**
     * @return rremark
     */
    public String getRremark() {
        return rremark;
    }

    /**
     * @param rremark
     */
    public void setRremark(String rremark) {
        this.rremark = rremark == null ? null : rremark.trim();
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