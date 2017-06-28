package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "message_sys")
public class MessageSys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "news_content")
    private String newsContent;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "function_content")
    private String functionContent;

    @Column(name = "create_time")
    @JsonSerialize(using = DateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer type;

    @Column(name = "is_read")
    private Integer isRead;

    @Column(name = "read_time")
    @JsonSerialize(using = DateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * @return function_content
     */
    public String getFunctionContent() {
        return functionContent;
    }

    /**
     * @param functionContent
     */
    public void setFunctionContent(String functionContent) {
        this.functionContent = functionContent == null ? null : functionContent.trim();
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
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return is_read
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * @param isRead
     */
    public void setIsRead(Integer isRead) {
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