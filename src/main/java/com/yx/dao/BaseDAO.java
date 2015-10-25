package com.yx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by ÐÀ on 2015/10/24 0024.
 */
@Component("baseDAO")
public class BaseDAO {

    //@Autowired
    //private ShardedJedisPool shardedJedisPool;

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    public void save(final String key, final String value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(key.getBytes(), value.getBytes());
                return null;
            }
        });
    }


    public String read(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyByte = key.getBytes();
                if (connection.exists(keyByte)) {
                    byte[] value = connection.get(keyByte);
                    return new String(value);
                }
                return null;
            }
        });
    }
}
