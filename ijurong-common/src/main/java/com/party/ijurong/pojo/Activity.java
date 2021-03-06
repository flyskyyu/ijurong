package com.party.ijurong.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

public class Activity {
    /**
     * 主题
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "party_branch_id")
    private Integer partyBranchId;

    @Column(name = "party_branch_name")
    private String partyBranchName;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date endTime;

    @Column(name = "publish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date publishTime;

    private Integer flag;

    private String address;

    private String results;

    /**
     * 情况
     */
    private String situation;

    /**
     * 活动类型(党员专题活动，教育教学活动，志愿者活动，生活活动)
     */
    private Integer type;

    private Integer integral;

    private String detail;

    @Column(name = "click_amount")
    private Integer clickAmount;

    private String avatar;

    @Transient
    private Integer orderType;

    /**
     * 回复数
     */
    @Column(name = "reply_num")
    @JsonIgnore
    private Integer replyNum;

    @Column(name = "like_num")
    @JsonIgnore
    private Integer likeNum;

    /**
     * 获取主题
     *
     * @return id - 主题
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主题
     *
     * @param id 主题
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
     * @return party_branch_id
     */
    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    /**
     * @param partyBranchId
     */
    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
    }

    /**
     * @return party_branch_name
     */
    public String getPartyBranchName() {
        return partyBranchName;
    }

    /**
     * @param partyBranchName
     */
    public void setPartyBranchName(String partyBranchName) {
        this.partyBranchName = partyBranchName == null ? null : partyBranchName.trim();
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
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
     * @return results
     */
    public String getResults() {
        return results;
    }

    /**
     * @param results
     */
    public void setResults(String results) {
        this.results = results == null ? null : results.trim();
    }

    /**
     * 获取情况
     *
     * @return situation - 情况
     */
    public String getSituation() {
        return situation;
    }

    /**
     * 设置情况
     *
     * @param situation 情况
     */
    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }

    /**
     * 获取活动类型(党员专题活动，教育教学活动，志愿者活动，生活活动)
     *
     * @return type - 活动类型(党员专题活动，教育教学活动，志愿者活动，生活活动)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置活动类型(党员专题活动，教育教学活动，志愿者活动，生活活动)
     *
     * @param type 活动类型(党员专题活动，教育教学活动，志愿者活动，生活活动)
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getClickAmount() {
        return clickAmount;
    }

    public void setClickAmount(Integer clickAmount) {
        this.clickAmount = clickAmount;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}