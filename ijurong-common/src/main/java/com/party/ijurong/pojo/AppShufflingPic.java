package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

@Table(name = "app_shuffling_pic")
public class AppShufflingPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private Integer type;

    private Integer flag;//0为首页 1为物品兑换

    /**
     * 图片功能（app提供一下，用来返回给app，app点击后跳转到相应的界面）可以是url
     */
    @Column(name = "to_function")
    private String toFunction;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注/介绍
     */
    private String back;

    /**
     * 是否删除 0否 1是
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "create_time")
    @JsonSerialize(using = DateSerializer.class)
    private Date createTime;


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
     * 获取图片功能（app提供一下，用来返回给app，app点击后跳转到相应的界面）可以是url
     *
     * @return to_function - 图片功能（app提供一下，用来返回给app，app点击后跳转到相应的界面）可以是url
     */
    public String getToFunction() {
        return toFunction;
    }

    /**
     * 设置图片功能（app提供一下，用来返回给app，app点击后跳转到相应的界面）可以是url
     *
     * @param toFunction 图片功能（app提供一下，用来返回给app，app点击后跳转到相应的界面）可以是url
     */
    public void setToFunction(String toFunction) {
        this.toFunction = toFunction == null ? null : toFunction.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取备注/介绍
     *
     * @return back - 备注/介绍
     */
    public String getBack() {
        return back;
    }

    /**
     * 设置备注/介绍
     *
     * @param back 备注/介绍
     */
    public void setBack(String back) {
        this.back = back == null ? null : back.trim();
    }

    /**
     * 获取是否删除 0否 1是
     *
     * @return is_delete - 是否删除 0否 1是
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除 0否 1是
     *
     * @param isDelete 是否删除 0否 1是
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}