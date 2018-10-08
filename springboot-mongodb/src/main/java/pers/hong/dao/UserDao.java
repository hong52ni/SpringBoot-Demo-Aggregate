package pers.hong.dao;

import pers.hong.entity.User;

public interface UserDao {
    void addUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);

    User findUserByUserName(String userName);

    User findUserByUserId(Long id);
}
