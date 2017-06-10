package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Praise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "praised_id")
    private Integer praisedId;

    private Integer type;

    @Column(name = "praised_time")
    private Date praisedTime;

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
     * @return praised_id
     */
    public Integer getPraisedId() {
        return praisedId;
    }

    /**
     * @param praisedId
     */
    public void setPraisedId(Integer praisedId) {
        this.praisedId = praisedId;
    }

    /**
     * 获取1,活动,2,评论
     *
     * @return type - 1,活动,2,评论
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1,活动,2,评论
     *
     * @param type 1,活动,2,评论
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return praised_time
     */
    public Date getPraisedTime() {
        return praisedTime;
    }

    /**
     * @param praisedTime
     */
    public void setPraisedTime(Date praisedTime) {
        this.praisedTime = praisedTime;
    }
}