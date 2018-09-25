package pers.hong.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.hong.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 用户查询
     */
    @RequestMapping("/userList")
    @RequiresPermissions("user:view")
    public String userInfo() {
        return "userInfo";
    }

    /**
     * 用户添加;
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("user:add")
    public String userAdd() {
        return "userAdd";
    }

    /**
     * 用户删除;
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("user:del")
    public String userDel() {
        return "userDel";
    }
}
