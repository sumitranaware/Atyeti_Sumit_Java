package com.example.SpringBoot_CachingWithRedis.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisCacheConfig {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheConfiguration defaultConfig=RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(30))
                .disableCachingNullValues();

        Map<String ,RedisCacheConfiguration>configurationMap=new HashMap<>();
        configurationMap.put("userCache",defaultConfig.entryTtl(Duration.ofMinutes(5)));
        configurationMap.put("produceCache",defaultConfig.entryTtl(Duration.ofMinutes(10)));
        configurationMap.put("orderCache",defaultConfig.entryTtl(Duration.ofSeconds(60)));

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaultConfig)
                .withInitialCacheConfigurations(configurationMap)
                .build();
    }
}
