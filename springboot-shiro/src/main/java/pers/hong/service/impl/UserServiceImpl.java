package pers.hong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pers.hong.dao.UserDao;
import pers.hong.entity.User;
import pers.hong.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
