package pers.hong.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.hong.dao.UserDao;
import pers.hong.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: hong
 * @Date: 2018/09/15
 */
@RestController
@RequestMapping(value = "swagger")
@Api(value = "Swagger2在线文档")
public class UserController {
    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "userList",method = RequestMethod.GET)
    public Map<String, Object> getAllUserIinfo(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("用户集",userDao.findAll());
        return resultMap;
    }

    @ApiOperation(value = "根据id查询用户")
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public Map<String,Object> getUserById(@PathVariable @ApiParam(value = "主键") Long id){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("用户",userDao.findUserById(id));
        return resultMap;
    }
}
