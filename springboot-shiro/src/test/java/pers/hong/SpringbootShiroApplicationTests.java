package pers.hong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.hong.dao.UserDao;
import pers.hong.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShiroApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        User u = userDao.getUserByUserName("admin");
        System.out.println(u.getUserPasswrod());
    }


}
