package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date endTime;

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
}