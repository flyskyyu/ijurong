package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "car_order")
public class CarOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "is_agree")
    private Byte isAgree;

    /**
     * 备注
     */
    private String remark;

    private String reply;

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
     * @return car_id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
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
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return reply
     */
    public String getReply() {
        return reply;
    }

    /**
     * @param reply
     */
    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Byte getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Byte isAgree) {
        this.isAgree = isAgree;
    }
}