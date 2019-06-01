package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title:springbootstu
 * @Description:
 * @Author:shi.yihao
 * @Date:2019/5/1 下午4:45
 */
@ConfigurationProperties(prefix = "spring.syh.redis")
@Data
public class SyhRedisProperties {
    private String host;
    private int port;
    private String password;
}
