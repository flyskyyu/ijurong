package com.party.ijurong.service;

import com.party.ijurong.common.SerializeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class RedisService {

    @Autowired(required = false)//如果Spring容器中有，就注入，没有就忽略
    private ShardedJedisPool shardedJedisPool;

    private <T> T execute(Function<T, ShardedJedis> fun) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            return fun.callback(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        return null;
    }

    public String set(final String key, final Object value) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.set(key.getBytes(), SerializeUtils.serialize(value));
            }
        });
    }

    public <T> T get(final String key) {
        return this.execute(new Function<T, ShardedJedis>() {
            @Override
            public T callback(ShardedJedis e) {
                byte[] bytes = e.get(key.getBytes());
                return (T)SerializeUtils.deserialize(bytes);
            }
        });
    }

    /**
     * 删除key
     * 
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.del(key.getBytes());
            }
        });
    }

    /**
     * 设置生存时间，单位为：秒
     * 
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key, final Integer seconds) {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.expire(key.getBytes(), seconds);
            }
        });
    }

    /**
     * 设置String类型的值，并且指定生存时间，单位为：秒
     * 
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String set(final String key, final Object value, final Integer seconds) {
        return this.execute(new Function<String, ShardedJedis>() {
            @Override
            public String callback(ShardedJedis e) {
                String result = e.set(key.getBytes(), SerializeUtils.serialize(value));
                e.expire(key.getBytes(), seconds);
                return result;
            }
        });
    }

    /**
     * 获取符合规则的key,*代表0个或多个，?代码一个
     * @param pattern
     * @return
     */
    public Set<String> keys(final String pattern) {
        return this.execute(new Function<Set, ShardedJedis>() {
            @Override
            public Set callback(ShardedJedis e) {
                Set set = new HashSet();
                Collection<Jedis> shards = e.getAllShards();
                for(Jedis jedis : shards) {
                   set.addAll(jedis.keys(pattern));
                }
                return set;
            }
        });
    }

    public Long dbSize() {
        return this.execute(new Function<Long, ShardedJedis>() {
            @Override
            public Long callback(ShardedJedis e) {
                long size = 0;
                Collection<Jedis> shards = e.getAllShards();
                for(Jedis jedis : shards) {
                    size += jedis.dbSize();
                }
                return size;
            }
        });
    }

    public void flushDB() {
        this.execute(new Function<Integer, ShardedJedis>() {
            @Override
            public Integer callback(ShardedJedis e) {
                Collection<Jedis> shards = e.getAllShards();
                for(Jedis jedis : shards) {
                    jedis.flushDB();
                }
                return 0;
            }
        });
    }
}
