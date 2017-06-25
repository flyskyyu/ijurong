package com.party.ijurong.websocket;

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
    private final static String TOKEN_KEY = "TOKEN_KEY";

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String token = (String) session.getAttributes().get(TOKEN_KEY);
        if(StringUtils.isEmpty(token)) {
            session.sendMessage(new TextMessage("没有token"));
        } else {
            logger.debug("websocket connect, token is {}", token);
            sessions.put(token, session);
            session.sendMessage(new TextMessage("success"));
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
}