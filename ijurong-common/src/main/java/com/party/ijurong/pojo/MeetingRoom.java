package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "meeting_room")
public class MeetingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String capacity;

    private String location;

    private String manager;

    private String phone;

    private String introduce;

    @Column(name = "party_branch_id")
    private Integer partyBranchId;

    private String imgs;

    @Transient
    private Boolean isUsing;

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
     * @return capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * @return manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * @param manager
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    /**
     * @return imgs
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * @param imgs
     */
    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public Boolean getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(Boolean isUsing) {
        this.isUsing = isUsing;
    }
}