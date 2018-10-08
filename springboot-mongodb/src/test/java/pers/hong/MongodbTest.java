package pers.hong;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.hong.dao.UserDao;
import pers.hong.entity.User;

@SpringBootTest
public class MongodbTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void addUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("小宏");
        user.setPassWord("abc123");
        userDao.addUser(user);
    }
}
