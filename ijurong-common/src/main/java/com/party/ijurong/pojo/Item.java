package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    @Column(name = "item_name")
    private String itemName;

    /**
     * 物品类型,1实物,2虚拟,3其它
     */
    private Integer type;

    /**
     * 物品介绍
     */
    private String introduce;

    /**
     * 物品个数
     */
    private Integer num;

    /**
     * 领取条件
     */
    private String conditions;

    /**
     * 所属功能模块1,党员回馈,2,员工物品
     */
    private Integer belong;

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
     * @return enterprise_id
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * @return item_name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 获取物品类型,1实物,2虚拟,3其它
     *
     * @return type - 物品类型,1实物,2虚拟,3其它
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置物品类型,1实物,2虚拟,3其它
     *
     * @param type 物品类型,1实物,2虚拟,3其它
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取物品介绍
     *
     * @return introduce - 物品介绍
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置物品介绍
     *
     * @param introduce 物品介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 获取物品个数
     *
     * @return num - 物品个数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置物品个数
     *
     * @param num 物品个数
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取领取条件
     *
     * @return conditions - 领取条件
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * 设置领取条件
     *
     * @param conditions 领取条件
     */
    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    /**
     * 获取所属功能模块1,党员回馈,2,员工物品
     *
     * @return belong - 所属功能模块1,党员回馈,2,员工物品
     */
    public Integer getBelong() {
        return belong;
    }

    /**
     * 设置所属功能模块1,党员回馈,2,员工物品
     *
     * @param belong 所属功能模块1,党员回馈,2,员工物品
     */
    public void setBelong(Integer belong) {
        this.belong = belong;
    }
}