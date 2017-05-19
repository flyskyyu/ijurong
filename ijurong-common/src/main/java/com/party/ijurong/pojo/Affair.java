package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Affair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "affair_content")
    private String affairContent;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    private String address;

    /**
     * 1,网上办事事项，2志愿者活动
     */
    private Integer type;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return affair_content
     */
    public String getAffairContent() {
        return affairContent;
    }

    /**
     * @param affairContent
     */
    public void setAffairContent(String affairContent) {
        this.affairContent = affairContent == null ? null : affairContent.trim();
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
     * @return create_user_id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return begin_time
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
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
     * 获取1,网上办事事项，2志愿者活动
     *
     * @return type - 1,网上办事事项，2志愿者活动
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1,网上办事事项，2志愿者活动
     *
     * @param type 1,网上办事事项，2志愿者活动
     */
    public void setType(Integer type) {
        this.type = type;
    }
}