// package com.erupothu.redis.config;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

// @Configuration
// @EnableRedisRepositories
// public class RedisConfig {
    
//     @Value("${redis.host}")
//     private String redisHostName;

//     @Value("${redis.port}")
//     private Integer redisPort;

//     @Bean
//     public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
//     RedisTemplate<?, ?> template = new RedisTemplate<>();
//     template.setConnectionFactory(connectionFactory);

//     return template;
//     }
// }
