package com.sping.redis.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoRedisApplication {

    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoRedisApplication.class, args);
    }

    @GetMapping("/test")
    public String redisTest() {
        String time = (String) redisTemplate.opsForValue().get("TIME");

        if (time == null) {
            redisTemplate.opsForValue().set("TIME", "0");
            time = "0";
        }
        Integer times = Integer.valueOf(time);

        times++;
        redisTemplate.opsForValue().set("TIME", String.valueOf(times));
        return time;
    }

}
