package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Stafflog {
    @Id
    @Column(name = "log_id")
    private Integer logId;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "in_time")
    private Date inTime;

    @Column(name = "out_time")
    private Date outTime;

    @Column(name = "in_ip")
    private String inIp;

    private String remark;

    /**
     * @return log_id
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * @param logId
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
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
     * @return in_time
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * @param inTime
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * @return out_time
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * @param outTime
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * @return in_ip
     */
    public String getInIp() {
        return inIp;
    }

    /**
     * @param inIp
     */
    public void setInIp(String inIp) {
        this.inIp = inIp == null ? null : inIp.trim();
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