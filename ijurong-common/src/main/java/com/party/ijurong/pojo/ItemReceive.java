package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "item_receive")
public class ItemReceive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    /**
     * 扣除积分
     */
    private Integer integral;

    /**
     * 申请时间
     */
    @Column(name = "apply_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date applyTime;

    @Column(name = "is_receive")
    private Byte isReceive;

    @Column(name = "is_agree")
    private Byte isAgree;

    private String reply;

    /**
     * 领取时间
     */
    @Column(name = "receive_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date receiveTime;

    private Integer num;

    /**
     * 收货地址
     */
    private String address;

    private String name;

    private String avatar;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 快递单号
     */
    @Column(name = "courier_no")
    private String courierNo;

    /**
     * 快递名称
     */
    @Column(name = "courier_name")
    private String courierName;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return item_id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取扣除积分
     *
     * @return integral - 扣除积分
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 设置扣除积分
     *
     * @param integral 扣除积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * @return is_receive
     */
    public Byte getIsReceive() {
        return isReceive;
    }

    /**
     * @param isReceive
     */
    public void setIsReceive(Byte isReceive) {
        this.isReceive = isReceive;
    }

    public Byte getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Byte isAgree) {
        this.isAgree = isAgree;
    }

    /**
     * 获取领取时间
     *
     * @return receive_time - 领取时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置领取时间
     *
     * @param receiveTime 领取时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取收货地址
     *
     * @return address - 收货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置收货地址
     *
     * @param address 收货地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取快递单号
     *
     * @return courier_no - 快递单号
     */
    public String getCourierNo() {
        return courierNo;
    }

    /**
     * 设置快递单号
     *
     * @param courierNo 快递单号
     */
    public void setCourierNo(String courierNo) {
        this.courierNo = courierNo == null ? null : courierNo.trim();
    }

    /**
     * 获取快递名称
     *
     * @return courier_name - 快递名称
     */
    public String getCourierName() {
        return courierName;
    }

    /**
     * 设置快递名称
     *
     * @param courierName 快递名称
     */
    public void setCourierName(String courierName) {
        this.courierName = courierName == null ? null : courierName.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}