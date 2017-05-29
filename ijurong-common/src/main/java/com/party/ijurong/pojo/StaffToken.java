package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "staff_token")
public class StaffToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    private String token;

    @Column(name = "device_number")
    private String deviceNumber;

    private String platform;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "token_refresh_time")
    private Date tokenRefreshTime;

    @Column(name = "expire_time")
    private Date expireTime;

    private String ip;

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
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * @return platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    /**
     * @return login_time
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * @return token_refresh_time
     */
    public Date getTokenRefreshTime() {
        return tokenRefreshTime;
    }

    /**
     * @param tokenRefreshTime
     */
    public void setTokenRefreshTime(Date tokenRefreshTime) {
        this.tokenRefreshTime = tokenRefreshTime;
    }

    /**
     * @return expire_time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }
}