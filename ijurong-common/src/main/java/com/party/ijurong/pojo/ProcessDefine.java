package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "process_define")
public class ProcessDefine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "affair_id")
    private Integer affairId;

    private Integer origin;

    @Column(name = "process_name")
    private String processName;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "next_process_id")
    private Integer nextProcessId;

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
     * @return affair_id
     */
    public Integer getAffairId() {
        return affairId;
    }

    /**
     * @param affairId
     */
    public void setAffairId(Integer affairId) {
        this.affairId = affairId;
    }

    /**
     * @return origin
     */
    public Integer getOrigin() {
        return origin;
    }

    /**
     * @param origin
     */
    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    /**
     * @return process_name
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * @param processName
     */
    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
     * @return next_process_id
     */
    public Integer getNextProcessId() {
        return nextProcessId;
    }

    /**
     * @param nextProcessId
     */
    public void setNextProcessId(Integer nextProcessId) {
        this.nextProcessId = nextProcessId;
    }
}