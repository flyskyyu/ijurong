package com.party.ijurong.pojo;

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

    /**
     * 时间
     */
    private Date time;

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
     * 获取时间
     *
     * @return time - 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
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
}