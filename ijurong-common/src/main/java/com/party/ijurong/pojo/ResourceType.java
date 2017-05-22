package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "resource_type")
public class ResourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型名称
     */
    private String type;

    @Column(name = "create_time")
    @JsonSerialize(using = DateSerializer.class)
    private Date createTime;

    @Column(name = "create_uer_id")
    private Integer createUerId;

    /**
     * 备注
     */
    private String remark;

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
     * 获取类型名称
     *
     * @return type - 类型名称
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型名称
     *
     * @param type 类型名称
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
     * @return create_uer_id
     */
    public Integer getCreateUerId() {
        return createUerId;
    }

    /**
     * @param createUerId
     */
    public void setCreateUerId(Integer createUerId) {
        this.createUerId = createUerId;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}