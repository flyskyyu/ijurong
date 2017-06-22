package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date praisedTime;

    private String title;

    private String cover;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}