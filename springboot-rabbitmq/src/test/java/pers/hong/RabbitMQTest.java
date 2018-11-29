package pers.hong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hong.controller.MessageProvider;
import pers.hong.controller.MessageProvider2;
import pers.hong.controller.MessageProvider3;

/**
 * @Description:
 * @Auther: zwh
 * @Date: 2018/11/16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMQTest {
    @Autowired
    private MessageProvider messageProvider;
    @Autowired
    private MessageProvider2 messageProvider2;
    @Autowired
    private MessageProvider3 topicExchange;

    @Test
    public void hello() throws Exception {
        for (int i = 0; i < 1000; i++) {
            messageProvider.send();
            messageProvider2.send();
            Thread.sleep(1000);
        }
    }

    @Test
    public void topic1() throws Exception {
        topicExchange.send1();
        topicExchange.send2();
    }
}
