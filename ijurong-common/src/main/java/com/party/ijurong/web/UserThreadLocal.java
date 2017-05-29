package com.party.ijurong.web;


import com.party.ijurong.bean.SimpleUser;

public class UserThreadLocal {

    private static final ThreadLocal<SimpleUser> LOCAL = new ThreadLocal<SimpleUser>();

    public static void set(SimpleUser user) {
        LOCAL.set(user);
    }

    public static SimpleUser get() {
        return LOCAL.get();
    }

}
