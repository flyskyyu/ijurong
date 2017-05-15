package com.party.ijurong.shiro;

import com.party.ijurong.service.RedisService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cloud on 2017/2/21.
 */
public class RedisSessionDAO extends AbstractSessionDAO {
    private final static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

    @Autowired
    private RedisService redisService;
    private Integer expire;

    /**
     * The Redis key prefix for the sessions
     */
    private final static String keyPrefix = "SHIRO_REDIS_SESSION:";

    @Override
    public void update(Session session) throws UnknownSessionException {
        this.saveSession(session);
    }

    /**
     * save session
     *
     * @param session
     * @throws UnknownSessionException
     */
    private void saveSession(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }

        String key = getKey(session.getId());
        session.setTimeout(expire * 1000);
        redisService.set(key, session, expire);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }
        redisService.del(this.getKey(session.getId()));

    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<Session>();

        Set<String> keys = redisService.keys(this.keyPrefix + "*");
        if (keys != null && keys.size() > 0) {
            for (String key : keys) {
                Session s = redisService.get(key);
                sessions.add(s);
            }
        }

        return sessions;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            logger.error("session id is null");
            return null;
        }

        Session s = redisService.get(this.getKey(sessionId));
        return s;
    }

    /**
     * 获得key
     *
     * @param sessionId
     * @return
     */
    private String getKey(Serializable sessionId) {
        String preKey = this.keyPrefix + sessionId;
        return preKey;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}
