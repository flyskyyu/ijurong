package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "check_num")
    private Integer checkNum;

    @Column(name = "release_user_id")
    private Integer releaseUserId;

    @Column(name = "release_time")
    private Date releaseTime;

    /**
     * 0删除,1未发布,2已发布
     */
    private Integer status;

    /**
     * 1发文,2收文
     */
    private Integer type;

    private String content;

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
     * 获取0删除,1未发布,2已发布
     *
     * @return status - 0删除,1未发布,2已发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0删除,1未发布,2已发布
     *
     * @param status 0删除,1未发布,2已发布
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取1发文,2收文
     *
     * @return type - 1发文,2收文
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1发文,2收文
     *
     * @param type 1发文,2收文
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}