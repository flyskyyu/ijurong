package com.party.ijurong.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Cloud on 2017/5/27.
 */
@Service
public class PropertyService {
    @Value("${shiro.expire}")
    public int TOKEN_EXPIRE;
}
