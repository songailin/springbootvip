package com.easysoft.redis;

import com.easysoft.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class SpringRedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedis() {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("name", "songail");
        String value = opsForValue.get("name");
        Assert.assertEquals("songail", value);
    }
}
