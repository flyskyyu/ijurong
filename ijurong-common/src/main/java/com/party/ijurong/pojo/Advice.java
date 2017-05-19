package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "advice_content")
    private String adviceContent;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "reply_time")
    private Date replyTime;

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
     * @return advice_content
     */
    public String getAdviceContent() {
        return adviceContent;
    }

    /**
     * @param adviceContent
     */
    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent == null ? null : adviceContent.trim();
    }

    /**
     * @return reply_content
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * @param replyContent
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    /**
     * @return reply_time
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * @param replyTime
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}