package pers.hong.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description:
 * @Auther: zwh
 * @Date: 2018/11/28
 */
@Configuration
public class TopicExchangeConfig {
    final static String message1 = "topic.message1";
    final static String message2 = "topic.message2";

    //定义队列
//    @Bean
//    public Queue queueMessage1() {
//        return new Queue(TopicExchangeConfig.message1);
//    }

    @Bean
    public Queue queueMessage2() {
        return new Queue(TopicExchangeConfig.message2);
    }

    //定义交换机
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("TopicExchange");
    }

    //绑定交换机和队列
    @Bean
    Binding binding1(Queue message1, TopicExchange exchange) {
        return BindingBuilder.bind(message1).to(exchange).with("topic.message1");
    }

    @Bean
    Binding binding2(Queue message2, TopicExchange exchange) {
        return BindingBuilder.bind(message2).to(exchange).with("topic.#");
    }
}
