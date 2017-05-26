package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "party_branch_info")
public class PartyBranchInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "enterprise_id")
    private Integer enterpriseId;



    /**
     * 组织代码
     */
    @Column(name = "organization_code")
    private String organizationCode;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "organization_type")
    private Integer organizationType;

    private String relationship;

    /**
     * 上级组织
     */
    @Column(name = "father_id")
    private Integer fatherId;

    /**
     * 成立日期
     */
    @Column(name = "setup_date")
    @JsonSerialize(using = DateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date setupDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 邮政编码
     */
    @Column(name = "postal_code")
    private String postalCode;

    private String address;

    private String remark;

    private String longitude;

    private String latitude;

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
     * @return enterprise_id
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }


    /**
     * 获取组织代码
     *
     * @return organization_code - 组织代码
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 设置组织代码
     *
     * @param organizationCode 组织代码
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * @return organization_name
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * @param organizationName
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    /**
     * @return organization_type
     */
    public Integer getOrganizationType() {
        return organizationType;
    }

    /**
     * @param organizationType
     */
    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    /**
     * @return relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * @param relationship
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }

    /**
     * 获取成立日期
     *
     * @return setup_date - 成立日期
     */
    public Date getSetupDate() {
        return setupDate;
    }

    /**
     * 设置成立日期
     *
     * @param setupDate 成立日期
     */
    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取邮政编码
     *
     * @return postal_code - 邮政编码
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 设置邮政编码
     *
     * @param postalCode 邮政编码
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
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

    /**
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }
}