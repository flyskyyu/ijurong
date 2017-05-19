package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "discussion_reply")
public class DiscussionReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "discussion_id")
    private Integer discussionId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "reply_time")
    private Date replyTime;

    @Column(name = "reply_id")
    private Integer replyId;

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
     * @return discussion_id
     */
    public Integer getDiscussionId() {
        return discussionId;
    }

    /**
     * @param discussionId
     */
    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
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

    /**
     * @return reply_id
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * @param replyId
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }
}