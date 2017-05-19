package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "volunteer_activity")
public class VolunteerActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "volunteer_id")
    private Integer volunteerId;

    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "is_pass")
    private Byte isPass;

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
     * @return volunteer_id
     */
    public Integer getVolunteerId() {
        return volunteerId;
    }

    /**
     * @param volunteerId
     */
    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
    }

    /**
     * @return activity_id
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * @param activityId
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * @return is_pass
     */
    public Byte getIsPass() {
        return isPass;
    }

    /**
     * @param isPass
     */
    public void setIsPass(Byte isPass) {
        this.isPass = isPass;
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