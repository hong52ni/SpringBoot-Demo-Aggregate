package pers.hong.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Auther: zwh
 * @Date: 2018/11/16
 */
//@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue() {
        return new Queue("hello");
    }
}
