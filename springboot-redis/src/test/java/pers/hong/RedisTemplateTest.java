package pers.hong;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:Redis缓存测试类
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
        if ("uzi".equals(stringRedisTemplate.opsForValue().get("rng"))){
            System.out.println("数据已存进缓存中");
        }else {
            System.out.println("缓存无数据");
        }
    }

    @Test
    public void testHash(){
        HashOperations<String,Object,Object> hash = stringRedisTemplate.opsForHash();
        hash.put("faker","skt","mid");
        if("mid".equals(hash.get("faker","skt"))){
            System.out.println("数据已存进缓存中");
        }else {
            System.out.println("缓存无数据");
        }
    }


}
