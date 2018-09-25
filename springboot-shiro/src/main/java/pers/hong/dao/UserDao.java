package pers.hong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.hong.entity.User;

@Mapper
public interface UserDao {
    @Select("select user_id,user_name,user_password from user where user_name=#{userName}")
    User getUserByUserName(@Param("userName") String userName);
}
