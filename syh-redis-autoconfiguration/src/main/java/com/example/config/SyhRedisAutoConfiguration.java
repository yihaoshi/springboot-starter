package com.example.config;

import com.example.core.SyhRedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import sun.jvm.hotspot.runtime.solaris_sparc.SolarisSPARCJavaThreadPDAccess;

/**
 * @Title:springbootstu
 * @Description:
 * @Author:shi.yihao
 * @Date:2019/6/1 下午4:47
 */
@Configuration
@EnableConfigurationProperties(value = {SyhRedisProperties.class})
@ConditionalOnClass(value = {JedisPoolConfig.class, JedisPool.class})
public class SyhRedisAutoConfiguration {
    @Autowired
    private SyhRedisProperties redisConfigProperties;

    @Bean
    public JedisPool jedisPool() {
        System.out.println("加载jedis...");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool  jedisPool = new JedisPool(jedisPoolConfig,redisConfigProperties.getHost(),redisConfigProperties.getPort(),1000*1,redisConfigProperties.getPassword());
        return jedisPool;
    }


    @Bean
    @ConditionalOnBean(JedisPool.class)
    public SyhRedisClient redisClient() {
        SyhRedisClient redisOperClient = new SyhRedisClient(jedisPool());
        return redisOperClient;
    }


}
