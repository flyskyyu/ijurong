package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "marked_id")
    private Integer markedId;

    private Integer type;

    @Column(name = "marked_time")
    private Date markedTime;

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
     * @return staff_id
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return marked_id
     */
    public Integer getMarkedId() {
        return markedId;
    }

    /**
     * @param markedId
     */
    public void setMarkedId(Integer markedId) {
        this.markedId = markedId;
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
     * @return marked_time
     */
    public Date getMarkedTime() {
        return markedTime;
    }

    /**
     * @param markedTime
     */
    public void setMarkedTime(Date markedTime) {
        this.markedTime = markedTime;
    }
}