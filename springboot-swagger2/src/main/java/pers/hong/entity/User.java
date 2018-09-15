package pers.hong.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description:
 * @Auther: hong
 * @Date: 2018/09/15
 */
@Entity
@ApiModel(value = "用户实体类")
public class User {
    @Id
    @GeneratedValue
    @ApiModelProperty(value = "主键")
    private Long id;
    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "用户名")
    private String userName;
    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User(Long id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {
    }
}
