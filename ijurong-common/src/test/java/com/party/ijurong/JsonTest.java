package com.party.ijurong;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.pojo.Car;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.*;

/**
 * Created by Cloud on 2017/2/21.
 */
public class JsonTest {
    /*public static void main(String[] args) throws IOException {
        SysUser user = new SysUser();
        user.setUserName("cloud");
        user.setPassword("asdfsdf");
        user.setBirthday(new Date());
        user.setUserId(123123);
        Random random = new Random();
        ObjectMapper mapper = new ObjectMapper();
        String content;
        content = mapper.writeValueAsString(user);
        long current = System.currentTimeMillis();
        List users = new ArrayList();
        for(int i = 0; i < 1000;i ++) {
            SysUser user1 = new SysUser();
            user1.setUserName("cloud");
            user1.setPassword("asdfsdf");
            user1.setBirthday(new Date());
            user1.setUserId(random.nextInt());
            users.add(user1);
        }
        String val1 = mapper.writeValueAsString(users);
        System.out.println("json大小：" + val1.getBytes().length);
        byte[] buffer1 = SerializeUtils.serialize(users);
        System.out.println("java序列化大小：" + buffer1.length);
        for(int i = 0; i < 1; i++) {
            user.setUserId(random.nextInt());
            String val = mapper.writeValueAsString(user);
            System.out.println("json大小：" + val.getBytes().length);
        }
        for(int i = 0; i < 1; i++) {
            mapper.readValue(content, SysUser.class);
        }
        System.out.println("json序列化耗时：" + (System.currentTimeMillis() - current));
        byte[] bytes = null;
        current = System.currentTimeMillis();
        bytes = SerializeUtils.serialize(user);
        for(int i = 0; i < 1; i++) {
            user.setUserId(random.nextInt());
            byte[] buffer = SerializeUtils.serialize(user);
            System.out.println("java序列化大小：" + buffer.length);
        }
        for(int i = 0; i < 1; i++) {
            SerializeUtils.deserialize(bytes);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("java序列化耗时：" + (System.currentTimeMillis() - current));

    }*/

    @Test
    public void testMobileResult() throws JsonProcessingException {
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setMsg("成功");
        List<Car> cars = new ArrayList<>();
        Car car = new Car();
        car.setCarNum("001");
        cars.add(car);
        car = new Car();
        car.setCarNum("002");
        cars.add(car);

        result.setData(car);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(result));
        result.setData(cars);
        System.out.println(objectMapper.writeValueAsString(result));
        result.setData(null);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(new Date().toString());
        System.out.println(new Random().nextInt());
        System.out.println("" + null);
    }

    @Test
    public void testDate() {
        System.out.println(DateUtils.truncate(new Date(), Calendar.DATE));
    }
}
