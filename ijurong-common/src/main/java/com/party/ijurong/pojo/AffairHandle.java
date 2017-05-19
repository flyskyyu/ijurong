package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "affair_handle")
public class AffairHandle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "process_id")
    private Integer processId;

    @Column(name = "user_id")
    private Integer userId;

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
     * @return process_id
     */
    public Integer getProcessId() {
        return processId;
    }

    /**
     * @param processId
     */
    public void setProcessId(Integer processId) {
        this.processId = processId;
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
}