package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "hard_member_apply")
public class HardMemberApply {
    public final static int YES = 1;
    public final static int NO = 0;
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
    private String hardType;

    /**
     * 说明
     */
    @Column(name = "hard_desc")
    private String hardDesc;

    @Column(name = "health_status")
    private String healthStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date birthday;

    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date joinDate;

    @Column(name = "work_situation")
    private String workSituation;

    @Column(name = "life_situation")
    private String lifeSituation;

    @Column(name = "other_desc")
    private String otherDesc;

    @Column(name = "police_station")
    private String policeStation;

    @Column(name = "is_agree")
    private Byte isAgree;

    private String reply;

    @Column(name = "apply_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
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
    public String getHardType() {
        return hardType;
    }

    /**
     * 设置困难类型
     *
     * @param hardType 困难类型
     */
    public void setHardType(String hardType) {
        this.hardType = hardType == null ? null : hardType.trim();
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
    public String getHealthStatus() {
        return healthStatus;
    }

    /**
     * @param healthStatus
     */
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus == null ? null : healthStatus.trim();
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return join_date
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return work_situation
     */
    public String getWorkSituation() {
        return workSituation;
    }

    /**
     * @param workSituation
     */
    public void setWorkSituation(String workSituation) {
        this.workSituation = workSituation == null ? null : workSituation.trim();
    }

    /**
     * @return life_situation
     */
    public String getLifeSituation() {
        return lifeSituation;
    }

    /**
     * @param lifeSituation
     */
    public void setLifeSituation(String lifeSituation) {
        this.lifeSituation = lifeSituation == null ? null : lifeSituation.trim();
    }

    /**
     * @return other_desc
     */
    public String getOtherDesc() {
        return otherDesc;
    }

    /**
     * @param otherDesc
     */
    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc == null ? null : otherDesc.trim();
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

    /**
     * @return apply_time
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * @param applyTime
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}