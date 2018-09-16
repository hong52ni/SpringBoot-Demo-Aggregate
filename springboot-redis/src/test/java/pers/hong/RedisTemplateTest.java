package pers.hong;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Auther: hong
 * @Date: 2018/09/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringTest(){
        stringRedisTemplate.opsForValue().set("rng","uzi");
        Assert.assertEquals("uzii",stringRedisTemplate.opsForValue().get("rng"));
    }
}
