package pers.hong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import pers.hong.entity.User;

@Mapper
public interface UserDao extends JpaRepository<User, Integer> {
    //    @Select("select user_id,user_name,user_password from user where user_name=#{userName}")
//    User getUserByUserName(@Param("userName") String userName);
    User findAllByUserName(@Param("userName") String userName);
    User getUserByUserName(@Param("userName") String userName);
}
