package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 1,新闻，2，通知，3，党务，4网上办事
     */
    private Integer origin;

    private String filename;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 附件类型
     */
    private Integer type;

    private String url;

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
     * 获取1,新闻，2，通知，3，党务，4网上办事
     *
     * @return origin - 1,新闻，2，通知，3，党务，4网上办事
     */
    public Integer getOrigin() {
        return origin;
    }

    /**
     * 设置1,新闻，2，通知，3，党务，4网上办事
     *
     * @param origin 1,新闻，2，通知，3，党务，4网上办事
     */
    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    /**
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
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
     * 获取附件类型
     *
     * @return type - 附件类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置附件类型
     *
     * @param type 附件类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}