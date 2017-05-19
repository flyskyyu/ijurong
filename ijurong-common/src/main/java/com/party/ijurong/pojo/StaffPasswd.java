package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "staff_passwd")
public class StaffPasswd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    private String password;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_staff_id")
    private Integer updateStaffId;

    @Column(name = "update_depart_id")
    private Integer updateDepartId;

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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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