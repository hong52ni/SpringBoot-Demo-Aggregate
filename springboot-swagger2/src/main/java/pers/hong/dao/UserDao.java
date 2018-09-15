package pers.hong.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.hong.entity.User;

import java.util.List;

/**
 * @Description:
 * @Auther: hong
 * @Date: 2018/09/15
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    User findUserById(Long id);
    List<User> findAll();
}
