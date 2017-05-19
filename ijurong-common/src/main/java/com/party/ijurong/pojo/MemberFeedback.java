package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "member_feedback")
public class MemberFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    private String gift;

    private Integer integral;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "is_receive")
    private Integer isReceive;

    @Column(name = "receive_time")
    private Date receiveTime;

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
     * @return gift
     */
    public String getGift() {
        return gift;
    }

    /**
     * @param gift
     */
    public void setGift(String gift) {
        this.gift = gift == null ? null : gift.trim();
    }

    /**
     * @return integral
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * @param integral
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return is_receive
     */
    public Integer getIsReceive() {
        return isReceive;
    }

    /**
     * @param isReceive
     */
    public void setIsReceive(Integer isReceive) {
        this.isReceive = isReceive;
    }

    /**
     * @return receive_time
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * @param receiveTime
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}