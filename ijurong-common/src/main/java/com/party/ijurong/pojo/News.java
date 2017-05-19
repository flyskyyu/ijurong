package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String subtitle;

    /**
     * 栏目id
     */
    @Column(name = "programa_id")
    private Integer programaId;

    /**
     * 专题id
     */
    @Column(name = "special_id")
    private Integer specialId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user_id")
    private Integer createUserId;

    private String origin;

    /**
     * 点击数
     */
    @Column(name = "check_num")
    private Integer checkNum;

    /**
     * 发布人
     */
    @Column(name = "release_user_id")
    private Integer releaseUserId;

    /**
     * 发布时间
     */
    @Column(name = "release_time")
    private Date releaseTime;

    /**
     * 0:删除,1:未发布,2:已发布
     */
    private Integer status;

    /**
     * 文章内容
     */
    @Column(name = "news_content")
    private String newsContent;

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
     * @return subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    /**
     * 获取栏目id
     *
     * @return programa_id - 栏目id
     */
    public Integer getProgramaId() {
        return programaId;
    }

    /**
     * 设置栏目id
     *
     * @param programaId 栏目id
     */
    public void setProgramaId(Integer programaId) {
        this.programaId = programaId;
    }

    /**
     * 获取专题id
     *
     * @return special_id - 专题id
     */
    public Integer getSpecialId() {
        return specialId;
    }

    /**
     * 设置专题id
     *
     * @param specialId 专题id
     */
    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
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
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    /**
     * 获取点击数
     *
     * @return check_num - 点击数
     */
    public Integer getCheckNum() {
        return checkNum;
    }

    /**
     * 设置点击数
     *
     * @param checkNum 点击数
     */
    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    /**
     * 获取发布人
     *
     * @return release_user_id - 发布人
     */
    public Integer getReleaseUserId() {
        return releaseUserId;
    }

    /**
     * 设置发布人
     *
     * @param releaseUserId 发布人
     */
    public void setReleaseUserId(Integer releaseUserId) {
        this.releaseUserId = releaseUserId;
    }

    /**
     * 获取发布时间
     *
     * @return release_time - 发布时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 设置发布时间
     *
     * @param releaseTime 发布时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取0:删除,1:未发布,2:已发布
     *
     * @return status - 0:删除,1:未发布,2:已发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:删除,1:未发布,2:已发布
     *
     * @param status 0:删除,1:未发布,2:已发布
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取文章内容
     *
     * @return news_content - 文章内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 设置文章内容
     *
     * @param newsContent 文章内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}