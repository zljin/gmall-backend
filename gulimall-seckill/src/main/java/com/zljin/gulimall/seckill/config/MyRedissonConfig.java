package com.zljin.gulimall.seckill.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * RedisClient operate Redisson
 */
@Configuration
public class MyRedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson(@Value("${spring.redis.host}") String url) throws IOException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + url + ":6379");
        return Redisson.create(config);
    }
}
