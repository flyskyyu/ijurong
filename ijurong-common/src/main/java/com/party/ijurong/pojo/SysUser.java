package com.party.ijurong.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_user")
public class SysUser implements Serializable{
    /**
     * 用户Id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    @Column(name = "real_name")
    private String realName;

    private Integer sex;

    private Date birthday;

    @Column(name = "card_type_id")
    private Integer cardTypeId;

    @Column(name = "card_no")
    private String cardNo;

    /**
     * 外部邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 头像
     */
    private String photo;

    /**
     * 备注
     */
    private String note;

    /**
     * 创建者
     */
    @Column(name = "create_user")
    private Integer createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否冻结 0：否 1：是
     */
    private Boolean status;

    private Integer point;

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return real_name
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
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
     * @return card_type_id
     */
    public Integer getCardTypeId() {
        return cardTypeId;
    }

    /**
     * @param cardTypeId
     */
    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    /**
     * @return card_no
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取外部邮箱
     *
     * @return email - 外部邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置外部邮箱
     *
     * @param email 外部邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取头像
     *
     * @return photo - 头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置头像
     *
     * @param photo 头像
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取创建者
     *
     * @return create_user - 创建者
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建者
     *
     * @param createUser 创建者
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否冻结 0：否 1：是
     *
     * @return status - 是否冻结 0：否 1：是
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置是否冻结 0：否 1：是
     *
     * @param status 是否冻结 0：否 1：是
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return point
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * @param point
     */
    public void setPoint(Integer point) {
        this.point = point;
    }
}