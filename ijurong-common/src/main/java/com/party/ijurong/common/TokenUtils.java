package com.party.ijurong.common;

import com.party.ijurong.pojo.Staff;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.Random;

/**
 * Created by Cloud on 2017/5/27.
 */
public class TokenUtils {
    public static String generateToken(Staff staff) {
        long time = new Date().getTime();
        String result = "";
        result += time;
        result += staff.getStaffId() + staff.getStaffName() + staff.getIdentityId();
        result += new Random().nextInt();
        String token = DigestUtils.md5Hex(result);
        return token;
    }
}
