package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "hard_member_apply")
public class HardMemberApply {
    public final static int YES = 0;
    public final static int NO = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "is_hard_member")
    private Byte isHardMember;

    @Column(name = "is_old_member")
    private Byte isOldMember;

    @Column(name = "is_enjoy_MLA")
    private Byte isEnjoyMla;

    @Column(name = "is_enjoy_subsidy")
    private Byte isEnjoySubsidy;

    /**
     * 困难类型
     */
    @Column(name = "hard_type")
    private Integer hardType;

    /**
     * 说明
     */
    @Column(name = "hard_desc")
    private String hardDesc;

    @Column(name = "health_status")
    private Integer healthStatus;

    @Column(name = "police_station")
    private String policeStation;

    @Column(name = "is_agree")
    private Byte isAgree;

    private String reply;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "apply_time")
    private Date applyTime;

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
     * @return is_hard_member
     */
    public Byte getIsHardMember() {
        return isHardMember;
    }

    /**
     * @param isHardMember
     */
    public void setIsHardMember(Byte isHardMember) {
        this.isHardMember = isHardMember;
    }

    /**
     * @return is_old_member
     */
    public Byte getIsOldMember() {
        return isOldMember;
    }

    /**
     * @param isOldMember
     */
    public void setIsOldMember(Byte isOldMember) {
        this.isOldMember = isOldMember;
    }

    /**
     * @return is_enjoy_MLA
     */
    public Byte getIsEnjoyMla() {
        return isEnjoyMla;
    }

    /**
     * @param isEnjoyMla
     */
    public void setIsEnjoyMla(Byte isEnjoyMla) {
        this.isEnjoyMla = isEnjoyMla;
    }

    /**
     * @return is_enjoy_subsidy
     */
    public Byte getIsEnjoySubsidy() {
        return isEnjoySubsidy;
    }

    /**
     * @param isEnjoySubsidy
     */
    public void setIsEnjoySubsidy(Byte isEnjoySubsidy) {
        this.isEnjoySubsidy = isEnjoySubsidy;
    }

    /**
     * 获取困难类型
     *
     * @return hard_type - 困难类型
     */
    public Integer getHardType() {
        return hardType;
    }

    /**
     * 设置困难类型
     *
     * @param hardType 困难类型
     */
    public void setHardType(Integer hardType) {
        this.hardType = hardType;
    }

    /**
     * 获取说明
     *
     * @return hard_desc - 说明
     */
    public String getHardDesc() {
        return hardDesc;
    }

    /**
     * 设置说明
     *
     * @param hardDesc 说明
     */
    public void setHardDesc(String hardDesc) {
        this.hardDesc = hardDesc == null ? null : hardDesc.trim();
    }

    /**
     * @return health_status
     */
    public Integer getHealthStatus() {
        return healthStatus;
    }

    /**
     * @param healthStatus
     */
    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    /**
     * @return police_station
     */
    public String getPoliceStation() {
        return policeStation;
    }

    /**
     * @param policeStation
     */
    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation == null ? null : policeStation.trim();
    }

    /**
     * @return is_agree
     */
    public Byte getIsAgree() {
        return isAgree;
    }

    /**
     * @param isAgree
     */
    public void setIsAgree(Byte isAgree) {
        this.isAgree = isAgree;
    }

    /**
     * @return reply
     */
    public String getReply() {
        return reply;
    }

    /**
     * @param reply
     */
    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}