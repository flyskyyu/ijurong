package com.party.ijurong.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "depart_id")
    private Integer departId;

    @Column(name = "party_branch_id")
    private Integer partyBranchId;

    @Column(name = "staff_name")
    private String staffName;

    /**
     * 岗位说明
     */
    @Column(name = "job_info")
    private String jobInfo;

    /**
     * 职务说明
     */
    @Column(name = "manager_info")
    private String managerInfo;

    //头像
    private String avatar;

    @Column(name = "political_status")
    private Integer politicalStatus;

    private Byte sex;

    private String email;

    @JsonIgnore
    private String password;

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

    /**
     * 民族
     */
    private String nation;

    /**
     * 备用电话
     */
    @Column(name = "spare_phone")
    private String sparePhone;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 籍贯
     */
    @Column(name = "origin_place")
    private String originPlace;

    /**
     * 现居地址
     */
    private String address;

    /**
     * 积分
     */
    private Integer integral;

    @Column(name = "dimission_tag")
    private Byte dimissionTag;

    private String hobby;

    @DateTimeFormat(pattern = "yyyy-MM-dd") //接收的参数格式
    @JsonSerialize(using = DateSerializer.class) //让返回的json日期格式为yyyy-MM-dd
    private Date birthday;

    private String remark;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_staff_id")
    private Integer updateStaffId;

    private Integer active;
    @Column(name = "head_char")
    private String headChar;

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

    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
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
     * 获取岗位说明
     *
     * @return job_info - 岗位说明
     */
    public String getJobInfo() {
        return jobInfo;
    }

    /**
     * 设置岗位说明
     *
     * @param jobInfo 岗位说明
     */
    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo == null ? null : jobInfo.trim();
    }

    /**
     * 获取职务说明
     *
     * @return manager_info - 职务说明
     */
    public String getManagerInfo() {
        return managerInfo;
    }

    /**
     * 设置职务说明
     *
     * @param managerInfo 职务说明
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
     * 获取民族
     *
     * @return nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 获取备用电话
     *
     * @return spare_phone - 备用电话
     */
    public String getSparePhone() {
        return sparePhone;
    }

    /**
     * 设置备用电话
     *
     * @param sparePhone 备用电话
     */
    public void setSparePhone(String sparePhone) {
        this.sparePhone = sparePhone == null ? null : sparePhone.trim();
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public Integer getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(Integer education) {
        this.education = education;
    }

    /**
     * 获取籍贯
     *
     * @return origin_place - 籍贯
     */
    public String getOriginPlace() {
        return originPlace;
    }

    /**
     * 设置籍贯
     *
     * @param originPlace 籍贯
     */
    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace == null ? null : originPlace.trim();
    }

    /**
     * 获取现居地址
     *
     * @return address - 现居地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置现居地址
     *
     * @param address 现居地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取积分
     *
     * @return integral - 积分
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 设置积分
     *
     * @param integral 积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(Integer politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getHeadChar() {
        return headChar;
    }

    public void setHeadChar(String headChar) {
        this.headChar = headChar;
    }
}