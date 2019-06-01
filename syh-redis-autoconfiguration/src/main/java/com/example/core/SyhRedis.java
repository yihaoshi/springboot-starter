package com.example.core;

/**
 * @Title:springbootstu
 * @Description:接口类
 * @Author:shi.yihao
 * @Date:2019/5/1 下午4:48
 */

public interface SyhRedis {
    String set(String key,String val);

    String get(String key);
}
