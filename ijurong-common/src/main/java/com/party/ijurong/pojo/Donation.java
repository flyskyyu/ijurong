package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "party_branch_id")
    private Integer partyBranchId;

    private String phone;

    /**
     * 捐赠清单
     */
    @Column(name = "donation_list")
    private String donationList;

    /**
     * 捐助时间
     */
    @Column(name = "donation_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date donationTime;

    /**
     * 取货地址
     */
    private String address;

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
     * @return staff_name
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取捐赠清单
     *
     * @return donation_list - 捐赠清单
     */
    public String getDonationList() {
        return donationList;
    }

    /**
     * 设置捐赠清单
     *
     * @param donationList 捐赠清单
     */
    public void setDonationList(String donationList) {
        this.donationList = donationList == null ? null : donationList.trim();
    }

    /**
     * 获取捐助时间
     *
     * @return donation_time - 捐助时间
     */
    public Date getDonationTime() {
        return donationTime;
    }

    /**
     * 设置捐助时间
     *
     * @param donationTime 捐助时间
     */
    public void setDonationTime(Date donationTime) {
        this.donationTime = donationTime;
    }

    /**
     * 获取取货地址
     *
     * @return address - 取货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置取货地址
     *
     * @param address 取货地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
    }
}