package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "affair_handle_history")
public class AffairHandleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "process_id")
    private Integer processId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "transactor_id")
    private Integer transactorId;

    private String results;

    @Column(name = "create_time")
    private Date createTime;

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

    /**
     * @return transactor_id
     */
    public Integer getTransactorId() {
        return transactorId;
    }

    /**
     * @param transactorId
     */
    public void setTransactorId(Integer transactorId) {
        this.transactorId = transactorId;
    }

    /**
     * @return results
     */
    public String getResults() {
        return results;
    }

    /**
     * @param results
     */
    public void setResults(String results) {
        this.results = results == null ? null : results.trim();
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
}