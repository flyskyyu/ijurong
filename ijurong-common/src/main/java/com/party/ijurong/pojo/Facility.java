package com.party.ijurong.pojo;

import javax.persistence.*;

public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer num;

    private String remark;

    @Column(name = "party_branch_id")
    private Integer partyBranchId;

    private Integer type;

    private String avatar;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
}