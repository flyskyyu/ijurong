package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "message_user")
public class MessageUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 0：未读，1已读
     */
    @Column(name = "is_read")
    private Byte isRead;

    @Column(name = "read_time")
    private Date readTime;

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
     * @return message_id
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * @param messageId
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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
     * 获取0：未读，1已读
     *
     * @return is_read - 0：未读，1已读
     */
    public Byte getIsRead() {
        return isRead;
    }

    /**
     * 设置0：未读，1已读
     *
     * @param isRead 0：未读，1已读
     */
    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }

    /**
     * @return read_time
     */
    public Date getReadTime() {
        return readTime;
    }

    /**
     * @param readTime
     */
    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
}