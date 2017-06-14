package com.party.ijurong;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.utils.RandomUtils;
import org.apache.commons.codec.digest.DigestUtils;
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
    public void testAliyunDuanxin() {
        /**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount("LTAITvtHB1Fsg2gL", "bmsU2RVQwm2nz4xJN0IGLpyncpZxRg", "http://1114397182345197.mns.cn-hangzhou.aliyuncs.com/");
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef("sms.topic-cn-hangzhou");
        /**
         * Step 2. 设置SMS消息体（必须）
         *
         * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
         */
        RawTopicMessage msg = new RawTopicMessage();
        msg.setMessageBody("sms-message");
        /**
         * Step 3. 生成SMS消息属性
         */
        MessageAttributes messageAttributes = new MessageAttributes();
        BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
        // 3.1 设置发送短信的签名（SMSSignName）
        batchSmsAttributes.setFreeSignName("句容微腾短信网关");
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode("SMS_71050007");
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("regmsg", "123456");
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver("18951572022", smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        try {
            /**
             * Step 4. 发布SMS消息
             */
            TopicMessage ret = topic.publishMessage(msg, messageAttributes);
            System.out.println("MessageId: " + ret.getMessageId());
            System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
        } catch (ServiceException se) {
            System.out.println(se.getErrorCode() + se.getRequestId());
            System.out.println(se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
    }

    @Test
    public void testValid() {
        for(int i = 0; i < 10000; i++) {
            Assert.assertTrue(RandomUtils.generateValidCode().length() == 6);
        }
    }

    @Test
    public void testmd5() {
        System.out.println(DigestUtils.md5Hex("123"));
    }
}
