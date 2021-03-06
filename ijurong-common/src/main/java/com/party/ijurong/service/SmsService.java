package com.party.ijurong.service;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/13 0013.
 */
@Service
public class SmsService {
    @Value("${mns.accountendpoint}")
    private String accountendpoint;
    @Value("${mns.accesskeyid}")
    private String accesskeyid;
    @Value("${mns.accesskeysecret}")
    private String accesskeysecret;
    @Value("${mns.topic}")
    private String topicName;
    @Value("${mns.freeSign}")
    private String freeSign;
    @Value("${mns.templateCode}")
    private String templateCode;

    public void sendValidCode(String phone, String code) {
        /**
         * Step 1. 获取主题引用
         */
        CloudAccount account = new CloudAccount(accesskeyid, accesskeysecret, accountendpoint);
        MNSClient client = account.getMNSClient();
        CloudTopic topic = client.getTopicRef(topicName);
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
        batchSmsAttributes.setFreeSignName(freeSign);
        // 3.2 设置发送短信使用的模板（SMSTempateCode）
        batchSmsAttributes.setTemplateCode(templateCode);
        // 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
        BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
        smsReceiverParams.setParam("regmsg", code);
        // 3.4 增加接收短信的号码
        batchSmsAttributes.addSmsReceiver(phone, smsReceiverParams);
        messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
        /**
         * Step 4. 发布SMS消息
         */
        TopicMessage ret = topic.publishMessage(msg, messageAttributes);
        System.out.println("MessageId: " + ret.getMessageId());
        System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
        client.close();
    }
}
