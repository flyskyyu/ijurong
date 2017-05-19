package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "party_work_public")
public class PartyWorkPublic {
    /**
     * 0;删除，1未发布,2已发布
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "programa_id")
    private Integer programaId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "check_num")
    private Integer checkNum;

    @Column(name = "release_user_id")
    private Integer releaseUserId;

    @Column(name = "release_time")
    private Date releaseTime;

    private Integer status;

    @Column(name = "news_content")
    private String newsContent;

    /**
     * 获取0;删除，1未发布,2已发布
     *
     * @return id - 0;删除，1未发布,2已发布
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置0;删除，1未发布,2已发布
     *
     * @param id 0;删除，1未发布,2已发布
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
     * @return programa_id
     */
    public Integer getProgramaId() {
        return programaId;
    }

    /**
     * @param programaId
     */
    public void setProgramaId(Integer programaId) {
        this.programaId = programaId;
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
     * @return check_num
     */
    public Integer getCheckNum() {
        return checkNum;
    }

    /**
     * @param checkNum
     */
    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    /**
     * @return release_user_id
     */
    public Integer getReleaseUserId() {
        return releaseUserId;
    }

    /**
     * @param releaseUserId
     */
    public void setReleaseUserId(Integer releaseUserId) {
        this.releaseUserId = releaseUserId;
    }

    /**
     * @return release_time
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * @param releaseTime
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return news_content
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * @param newsContent
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}