package com.party.ijurong.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
public class SmsUtils {
    private final static String url = "http://eco.taobao.com/router/rest";
    private final static String appkey = "24251394";
    private final static String secret = "5c558cd663dbfdba46fb75a4866cbf85";

    public static void sendValidCode(String phone, String code) throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType("normal");
        req.setSmsFreeSignName("句容党建验证码");
        req.setSmsParamString("{\"code\":\"" + code + "\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_70565468");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}
