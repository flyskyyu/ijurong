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
     * 所属党支部
     */
    @Column(name = "party_branch_id")
    private Integer partyBranchId;

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
     * 获取所属党支部
     *
     * @return party_branch_id - 所属党支部
     */
    public Integer getPartyBranchId() {
        return partyBranchId;
    }

    /**
     * 设置所属党支部
     *
     * @param partyBranchId 所属党支部
     */
    public void setPartyBranchId(Integer partyBranchId) {
        this.partyBranchId = partyBranchId;
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
}