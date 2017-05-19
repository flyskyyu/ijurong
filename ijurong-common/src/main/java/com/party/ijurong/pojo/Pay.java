package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    /**
     * 订单状态,0待付款,付款完成,2付款失败
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 订单号
     */
    @Column(name = "pay_sn")
    private String paySn;

    private Long money;

    /**
     * 平台(ios,android)
     */
    private String platform;

    /**
     * 支付平台
     */
    @Column(name = "pay_platform")
    private String payPlatform;

    /**
     * 是否失效
     */
    @Column(name = "is_delete")
    private Integer isDelete;

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
     * 获取订单状态,0待付款,付款完成,2付款失败
     *
     * @return order_status - 订单状态,0待付款,付款完成,2付款失败
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态,0待付款,付款完成,2付款失败
     *
     * @param orderStatus 订单状态,0待付款,付款完成,2付款失败
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取订单号
     *
     * @return pay_sn - 订单号
     */
    public String getPaySn() {
        return paySn;
    }

    /**
     * 设置订单号
     *
     * @param paySn 订单号
     */
    public void setPaySn(String paySn) {
        this.paySn = paySn == null ? null : paySn.trim();
    }

    /**
     * @return money
     */
    public Long getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(Long money) {
        this.money = money;
    }

    /**
     * 获取平台(ios,android)
     *
     * @return platform - 平台(ios,android)
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 设置平台(ios,android)
     *
     * @param platform 平台(ios,android)
     */
    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    /**
     * 获取支付平台
     *
     * @return pay_platform - 支付平台
     */
    public String getPayPlatform() {
        return payPlatform;
    }

    /**
     * 设置支付平台
     *
     * @param payPlatform 支付平台
     */
    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform == null ? null : payPlatform.trim();
    }

    /**
     * 获取是否失效
     *
     * @return is_delete - 是否失效
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否失效
     *
     * @param isDelete 是否失效
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}