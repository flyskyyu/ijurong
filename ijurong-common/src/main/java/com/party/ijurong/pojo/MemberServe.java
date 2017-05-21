package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "member_serve")
public class MemberServe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组织名称
     */
    @Column(name = "organization_name")
    private String organizationName;

    /**
     * 负责人姓名
     */
    @Column(name = "contact_person_name")
    private String contactPersonName;

    /**
     * 被服务党员
     */
    @Column(name = "serviced_user_id")
    private Integer servicedUserId;

    /**
     * 服务时间
     */
    @Column(name = "service_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class) //让返回的json日期格式为yyyy-MM-dd
    private Date serviceDate;

    private String address;

    /**
     * 跟踪情况
     */
    private String situation;

    /**
     * 服务结果
     */
    private String result;

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
     * 获取组织名称
     *
     * @return organization_name - 组织名称
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * 设置组织名称
     *
     * @param organizationName 组织名称
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    /**
     * 获取负责人姓名
     *
     * @return contact_person_name - 负责人姓名
     */
    public String getContactPersonName() {
        return contactPersonName;
    }

    /**
     * 设置负责人姓名
     *
     * @param contactPersonName 负责人姓名
     */
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName == null ? null : contactPersonName.trim();
    }

    /**
     * 获取被服务党员
     *
     * @return serviced_user_id - 被服务党员
     */
    public Integer getServicedUserId() {
        return servicedUserId;
    }

    /**
     * 设置被服务党员
     *
     * @param servicedUserId 被服务党员
     */
    public void setServicedUserId(Integer servicedUserId) {
        this.servicedUserId = servicedUserId;
    }

    /**
     * 获取服务时间
     *
     * @return service_date - 服务时间
     */
    public Date getServiceDate() {
        return serviceDate;
    }

    /**
     * 设置服务时间
     *
     * @param serviceDate 服务时间
     */
    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取跟踪情况
     *
     * @return situation - 跟踪情况
     */
    public String getSituation() {
        return situation;
    }

    /**
     * 设置跟踪情况
     *
     * @param situation 跟踪情况
     */
    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }

    /**
     * 获取服务结果
     *
     * @return result - 服务结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置服务结果
     *
     * @param result 服务结果
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}