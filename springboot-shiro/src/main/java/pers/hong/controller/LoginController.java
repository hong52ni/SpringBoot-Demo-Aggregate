package pers.hong.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码错误";
            } else {
                msg = "其他错误" + exception;
            }
        }
        map.put("msg", msg);
        return "/login";
    }

    @RequestMapping("/403")
    public String unAuthorizedRole() {
        return "403";
    }

}
