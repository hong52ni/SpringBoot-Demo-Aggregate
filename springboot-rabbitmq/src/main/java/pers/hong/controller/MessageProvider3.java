package pers.hong.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Auther: zwh
 * @Date: 2018/11/16
 */
@Component
public class MessageProvider3 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1() {
        String context = "message1";
        System.out.println("Sender1 : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message1", context);
    }

    public void send2() {
        String context = "message2";
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message2", context);
    }
}
