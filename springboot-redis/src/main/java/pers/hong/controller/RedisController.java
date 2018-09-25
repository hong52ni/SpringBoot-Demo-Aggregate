package pers.hong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: hong
 * @Date: 2018/09/15
 */
@RestController
public class RedisController {

    @RequestMapping("setSession")
    public Map<String,Object> setSession(HttpServletRequest request){
        Map<String,Object> resultMap = new HashMap<>();
        request.getSession().setAttribute("URL",request.getRequestURL());
        resultMap.put("req URL:",request.getRequestURI());
        return resultMap;
    }


//    @RequestMapping("setSession")
//    public Map<String,Object> setSession(HttpServletRequest request){
//        Map<String,Object> resultMap = new HashMap<>();
//        request.getSession().setAttribute("message",request.getRequestURL());
//        resultMap.put("req URL:",request.getRequestURI());
//        return resultMap;
//    }

    @RequestMapping("getSession")
    public Map<String,Object> getSession(HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message",request.getSession().getAttribute("message"));
        resultMap.put("sessionId",request.getSession().getId());
        return resultMap;
    }
}
