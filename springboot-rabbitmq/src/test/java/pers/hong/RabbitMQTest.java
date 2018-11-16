package pers.hong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hong.controller.MessageProvider;

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

    @Test
    public void hello() throws Exception {
        for (int i = 0; i < 1000; i++) {
            messageProvider.send();
            Thread.sleep(1000);
        }
    }
}
