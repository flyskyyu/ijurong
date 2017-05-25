package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_num")
    private String carNum;

    private String introduce;

    @Column(name = "party_branch_id")
    private Integer partyBranchId;

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
     * @return car_num
     */
    public String getCarNum() {
        return carNum;
    }

    /**
     * @param carNum
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum == null ? null : carNum.trim();
    }

    /**
     * @return introduce
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * @param introduce
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
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
}