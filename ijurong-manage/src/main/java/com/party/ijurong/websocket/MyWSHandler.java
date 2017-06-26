package com.party.ijurong.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.party.ijurong.pojo.Staff;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class MyWSHandler implements WebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Map<String, WebSocketSession> sessions = new HashMap<>();
    private final static String TOKEN_KEY = "HTTP.SESSION.ID";

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String token = (String) session.getAttributes().get(TOKEN_KEY);
        JSONObject json = new JSONObject();
        if(StringUtils.isEmpty(token)) {
            json.put("action", "fail");
            json.put("data", "没有token");
            session.sendMessage(new TextMessage(JSON.toJSONString(json)));
        } else {
            logger.debug("websocket connect, token is {}", token);
            sessions.put(token, session);
            json.put("action", "connect");
            json.put("data", token);
            session.sendMessage(new TextMessage(JSON.toJSONString(json)));
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        String token = (String) session.getAttributes().get(TOKEN_KEY);
        logger.debug("transport error, websocket connection closed......,token is {}", token);
        sessions.remove(token);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        String token = (String) session.getAttributes().get(TOKEN_KEY);
        logger.debug("websocket connection closed......,token is {}", token);
        sessions.remove(token);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给某个用户发送消息
     */
    public void sendMessageToUser(String token, String text) {
        WebSocketSession session = sessions.get(token);
        if(session != null) {
            try {
                session.sendMessage(new TextMessage(text));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendLoginMessage(String token, Staff staff) {
        String username = staff.getPhoneNumber();
        String password = staff.getPassword();
        JSONObject json = new JSONObject();
        json.put("action", "login");
        json.put("username", username);
        json.put("password", password);
        sendMessageToUser(token, JSON.toJSONString(json));
    }
}