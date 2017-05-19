package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Staff {
    @Id
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "depart_id")
    private Integer departId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "job_info")
    private String jobInfo;

    @Column(name = "manager_info")
    private String managerInfo;

    private Byte sex;

    private String email;

    /**
     * 身份证号码
     */
    @Column(name = "identity_id")
    private String identityId;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "dimission_tag")
    private Byte dimissionTag;

    private String hobby;

    private Date birthday;

    private String remark;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_staff_id")
    private Integer updateStaffId;

    @Column(name = "update_depart_id")
    private Integer updateDepartId;

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
     * @return job_info
     */
    public String getJobInfo() {
        return jobInfo;
    }

    /**
     * @param jobInfo
     */
    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo == null ? null : jobInfo.trim();
    }

    /**
     * @return manager_info
     */
    public String getManagerInfo() {
        return managerInfo;
    }

    /**
     * @param managerInfo
     */
    public void setManagerInfo(String managerInfo) {
        this.managerInfo = managerInfo == null ? null : managerInfo.trim();
    }

    /**
     * @return sex
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取身份证号码
     *
     * @return identity_id - 身份证号码
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * 设置身份证号码
     *
     * @param identityId 身份证号码
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    /**
     * 获取手机号码
     *
     * @return phone_number - 手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return dimission_tag
     */
    public Byte getDimissionTag() {
        return dimissionTag;
    }

    /**
     * @param dimissionTag
     */
    public void setDimissionTag(Byte dimissionTag) {
        this.dimissionTag = dimissionTag;
    }

    /**
     * @return hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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