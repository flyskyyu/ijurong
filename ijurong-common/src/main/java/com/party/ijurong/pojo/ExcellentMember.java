package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "excellent_member")
public class ExcellentMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String title;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 点击量
     */
    @Column(name = "click_amount")
    private Integer clickAmount;

    /**
     * 评选时间
     */
    @Column(name = "selection_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date selectionDate;

    /**
     * 先进事迹
     */
    @Column(name = "meritorious_deeds")
    private String meritoriousDeeds;

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
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取点击量
     *
     * @return click_amount - 点击量
     */
    public Integer getClickAmount() {
        return clickAmount;
    }

    /**
     * 设置点击量
     *
     * @param clickAmount 点击量
     */
    public void setClickAmount(Integer clickAmount) {
        this.clickAmount = clickAmount;
    }

    /**
     * 获取评选时间
     *
     * @return selection_date - 评选时间
     */
    public Date getSelectionDate() {
        return selectionDate;
    }

    /**
     * 设置评选时间
     *
     * @param selectionDate 评选时间
     */
    public void setSelectionDate(Date selectionDate) {
        this.selectionDate = selectionDate;
    }

    /**
     * 获取先进事迹
     *
     * @return meritorious_deeds - 先进事迹
     */
    public String getMeritoriousDeeds() {
        return meritoriousDeeds;
    }

    /**
     * 设置先进事迹
     *
     * @param meritoriousDeeds 先进事迹
     */
    public void setMeritoriousDeeds(String meritoriousDeeds) {
        this.meritoriousDeeds = meritoriousDeeds == null ? null : meritoriousDeeds.trim();
    }
}