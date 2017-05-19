package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Service {
    @Id
    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "service_name")
    private String serviceName;

    /**
     * 1-APP,2-WEB,3-两端共用
     */
    @Column(name = "service_type")
    private Short serviceType;

    private String remark;

    /**
     * @return service_id
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return service_name
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    /**
     * 获取1-APP,2-WEB,3-两端共用
     *
     * @return service_type - 1-APP,2-WEB,3-两端共用
     */
    public Short getServiceType() {
        return serviceType;
    }

    /**
     * 设置1-APP,2-WEB,3-两端共用
     *
     * @param serviceType 1-APP,2-WEB,3-两端共用
     */
    public void setServiceType(Short serviceType) {
        this.serviceType = serviceType;
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
}