package com.example.core;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Title:springbootstu
 * @Description:
 * @Author:shi.yihao
 * @Date:2019/5/1 下午4:49
 */
public class SyhRedisClient implements SyhRedis{
    private JedisPool jedisPool;

    public SyhRedisClient(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }



    @Override
    public String set(String key, String val) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.set(key, val);
        } catch (Exception e) {
            jedisPool.returnResource(jedis);
            return result;
        } finally {
            jedisPool.returnResource(jedis);
        }
        return result;
    }

    @Override
    public String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.get(key);
        } catch (Exception e) {
            jedisPool.returnResource(jedis);
            return result;
        } finally {
            jedisPool.returnResource(jedis);
        }
        return result;
    }
}
