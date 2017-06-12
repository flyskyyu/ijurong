package com.party.ijurong;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.utils.RandomUtils;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
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

    @Test
    public void testDAyu() {
        String url = "http://eco.taobao.com/router/rest";
        String appkey = "24251394";
        String secret = "5c558cd663dbfdba46fb75a4866cbf85";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("句容党建验证码");
        req.setSmsParamString("{\"code\":\"1234\"}");
        req.setRecNum("18951572022");
        req.setSmsTemplateCode("SMS_70565468");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
    }

    @Test
    public void testValid() {
        for(int i = 0; i < 10000; i++) {
            Assert.assertTrue(RandomUtils.generateValidCode().length() == 6);
        }

    }
}
