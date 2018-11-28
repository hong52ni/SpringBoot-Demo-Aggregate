package pers.hong.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: zwh
 * @Date: 2018/11/16
 */
@Component
@RabbitListener(queues = "topic.message")
public class MessageReceiver3 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("topic receive  : " + message);
    }
}
