package com.party.ijurong.bean;

import java.io.Serializable;

/**
 * Created by Cloud on 2017/2/22.
 */
public class SimpleUser implements Serializable{
    private Integer userId;
    private String userName;


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
