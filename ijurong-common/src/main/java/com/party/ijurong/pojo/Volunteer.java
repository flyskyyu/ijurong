package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "organization_id")
    private Integer organizationId;

    private String name;

    private Byte sex;

    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    private String time;

    /**
     * 特长
     */
    private String specialty;

    /**
     * 服务意向
     */
    private String intention;

    private String range;

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
     * @return organization_id
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return sex
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
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
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /**
     * 获取特长
     *
     * @return specialty - 特长
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * 设置特长
     *
     * @param specialty 特长
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    /**
     * 获取服务意向
     *
     * @return intention - 服务意向
     */
    public String getIntention() {
        return intention;
    }

    /**
     * 设置服务意向
     *
     * @param intention 服务意向
     */
    public void setIntention(String intention) {
        this.intention = intention == null ? null : intention.trim();
    }

    /**
     * @return range
     */
    public String getRange() {
        return range;
    }

    /**
     * @param range
     */
    public void setRange(String range) {
        this.range = range == null ? null : range.trim();
    }
}