package com.party.ijurong.utils;

import com.party.ijurong.pojo.Staff;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Cloud on 2017/5/27.
 */
public class RandomUtils {
    public static String generateToken(Staff staff) {
        long time = new Date().getTime();
        String result = "";
        result += time;
        result += staff.getStaffId() + staff.getStaffName() + staff.getIdentityId();
        result += new Random().nextInt();
        String token = DigestUtils.md5Hex(result);
        return token;
    }

    //产生6位数随机数
    public static String generateValidCode() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int code = random.nextInt(100000, 1000000);
        return code + "";
    }
}
