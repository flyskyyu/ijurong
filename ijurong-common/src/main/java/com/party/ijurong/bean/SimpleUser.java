package com.party.ijurong.bean;

import com.party.ijurong.pojo.SysUser;

import java.io.Serializable;

/**
 * Created by Cloud on 2017/2/22.
 */
public class SimpleUser implements Serializable{
    private Integer userId;
    private String userName;

    public SimpleUser(SysUser user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }

    public SimpleUser() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
