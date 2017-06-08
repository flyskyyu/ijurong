package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "party_member")
public class PartyMember {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 进入当前支部时间
     */
    @Column(name = "join_branch_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class) //让返回的json日期格式为yyyy-MM-dd
    private Date joinBranchDate;

    /**
     * 党内职务
     */
    @Column(name = "party_position")
    private String partyPosition;

    /**
     * 月缴党费
     */
    @Column(name = "pay_dues")
    private Long payDues;

    /**
     * 申请入党日期
     */
    @Column(name = "apply_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class) //让返回的json日期格式为yyyy-MM-dd
    private Date applyDate;

    /**
     * 列为积极分子日期
     */
    @Column(name = "positive_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class) //让返回的json日期格式为yyyy-MM-dd
    private Date positiveDate;

    /**
     * 列为发展对象日期
     */
    @Column(name = "development_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class) //让返回的json日期格式为yyyy-MM-dd
    private Date developmentDate;

    /**
     * 加入中共组织日期
     */
    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class) //让返回的json日期格式为yyyy-MM-dd
    private Date joinDate;

    /**
     * 加入中共组织类型
     */
    @Column(name = "join_type")
    private Integer joinType;

    /**
     * 是否困难党员
     */
    @Column(name = "is_hard_member")
    private Byte isHardMember;

    @Column(name = "is_old_member")
    private Byte isOldMember;

    /**
     * 困难类型
     */
    @Column(name = "hard_type")
    private String hardType;

    /**
     * 是否享受低保(minimum living allowances)
     */
    @Column(name = "is_enjoy_MLA")
    private Byte isEnjoyMla;

    /**
     * 是否享受补贴
     */
    @Column(name = "is_enjoy_subsidy")
    private Byte isEnjoySubsidy;

    /**
     * 健康状态
     */
    @Column(name = "health_status")
    private String healthStatus;

    @Column(name = "work_situation")
    private String workSituation;

    @Column(name = "life_situation")
    private String lifeSituation;

    @Column(name = "other_desc")
    private String otherDesc;

    /**
     * 户口所在派出所
     */
    @Column(name = "police_station")
    private String policeStation;

    /**
     * 困难情况补充
     */
    @Column(name = "hard_desc")
    private String hardDesc;

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
     * 获取进入当前支部时间
     *
     * @return current_time - 进入当前支部时间
     */
    public Date getJoinBranchDate() {
        return joinBranchDate;
    }

    /**
     * 设置进入当前支部时间
     *
     * @param joinBranchDate 进入当前支部时间
     */
    public void setJoinBranchDate(Date joinBranchDate) {
        this.joinBranchDate = joinBranchDate;
    }

    /**
     * 获取党内职务
     *
     * @return party_position - 党内职务
     */
    public String getPartyPosition() {
        return partyPosition;
    }

    /**
     * 设置党内职务
     *
     * @param partyPosition 党内职务
     */
    public void setPartyPosition(String partyPosition) {
        this.partyPosition = partyPosition == null ? null : partyPosition.trim();
    }

    /**
     * 获取月缴党费
     *
     * @return pay_dues - 月缴党费
     */
    public Long getPayDues() {
        return payDues;
    }

    /**
     * 设置月缴党费
     *
     * @param payDues 月缴党费
     */
    public void setPayDues(Long payDues) {
        this.payDues = payDues;
    }

    /**
     * 获取申请入党日期
     *
     * @return apply_date - 申请入党日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请入党日期
     *
     * @param applyDate 申请入党日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取列为积极分子日期
     *
     * @return positive_date - 列为积极分子日期
     */
    public Date getPositiveDate() {
        return positiveDate;
    }

    /**
     * 设置列为积极分子日期
     *
     * @param positiveDate 列为积极分子日期
     */
    public void setPositiveDate(Date positiveDate) {
        this.positiveDate = positiveDate;
    }

    /**
     * 获取列为发展对象日期
     *
     * @return development_date - 列为发展对象日期
     */
    public Date getDevelopmentDate() {
        return developmentDate;
    }

    /**
     * 设置列为发展对象日期
     *
     * @param developmentDate 列为发展对象日期
     */
    public void setDevelopmentDate(Date developmentDate) {
        this.developmentDate = developmentDate;
    }

    /**
     * 获取加入中共组织日期
     *
     * @return join_date - 加入中共组织日期
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * 设置加入中共组织日期
     *
     * @param joinDate 加入中共组织日期
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * 获取加入中共组织类型
     *
     * @return join_type - 加入中共组织类型
     */
    public Integer getJoinType() {
        return joinType;
    }

    /**
     * 设置加入中共组织类型
     *
     * @param joinType 加入中共组织类型
     */
    public void setJoinType(Integer joinType) {
        this.joinType = joinType;
    }

    public Byte getIsHardMember() {
        return isHardMember;
    }

    public void setIsHardMember(Byte isHardMember) {
        this.isHardMember = isHardMember;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getHardDesc() {
        return hardDesc;
    }

    public void setHardDesc(String hardDesc) {
        this.hardDesc = hardDesc;
    }

    public Byte getIsOldMember() {
        return isOldMember;
    }

    public void setIsOldMember(Byte isOldMember) {
        this.isOldMember = isOldMember;
    }

    public String getHardType() {
        return hardType;
    }

    public void setHardType(String hardType) {
        this.hardType = hardType;
    }

    public Byte getIsEnjoyMla() {
        return isEnjoyMla;
    }

    public void setIsEnjoyMla(Byte isEnjoyMla) {
        this.isEnjoyMla = isEnjoyMla;
    }

    public Byte getIsEnjoySubsidy() {
        return isEnjoySubsidy;
    }

    public void setIsEnjoySubsidy(Byte isEnjoySubsidy) {
        this.isEnjoySubsidy = isEnjoySubsidy;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getWorkSituation() {
        return workSituation;
    }

    public void setWorkSituation(String workSituation) {
        this.workSituation = workSituation;
    }

    public String getLifeSituation() {
        return lifeSituation;
    }

    public void setLifeSituation(String lifeSituation) {
        this.lifeSituation = lifeSituation;
    }

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
    }
}