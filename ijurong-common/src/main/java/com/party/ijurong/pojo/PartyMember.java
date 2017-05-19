package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "party_member")
public class PartyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "party_branch_id")
    private Integer partyBranchId;

    @Column(name = "current_time")
    private Date currentTime;

    @Column(name = "party_position")
    private String partyPosition;

    @Column(name = "pay_dues")
    private Long payDues;

    /**
     * 申请入党日期
     */
    @Column(name = "apply_date")
    private Date applyDate;

    /**
     * 列为积极分子日期
     */
    @Column(name = "positive_date")
    private Date positiveDate;

    /**
     * 列为发展对象日期
     */
    @Column(name = "development_date")
    private Date developmentDate;

    /**
     * 加入中共组织日期
     */
    @Column(name = "join_date")
    private Date joinDate;

    @Column(name = "join_type")
    private Integer joinType;

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
     * @return party_branch_id
     */
    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    /**
     * @param partyBranchId
     */
    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
    }

    /**
     * @return current_time
     */
    public Date getCurrentTime() {
        return currentTime;
    }

    /**
     * @param currentTime
     */
    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * @return party_position
     */
    public String getPartyPosition() {
        return partyPosition;
    }

    /**
     * @param partyPosition
     */
    public void setPartyPosition(String partyPosition) {
        this.partyPosition = partyPosition == null ? null : partyPosition.trim();
    }

    /**
     * @return pay_dues
     */
    public Long getPayDues() {
        return payDues;
    }

    /**
     * @param payDues
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
     * @return join_type
     */
    public Integer getJoinType() {
        return joinType;
    }

    /**
     * @param joinType
     */
    public void setJoinType(Integer joinType) {
        this.joinType = joinType;
    }
}