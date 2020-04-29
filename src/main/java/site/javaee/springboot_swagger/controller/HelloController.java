package site.javaee.springboot_swagger.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.javaee.springboot_swagger.pojo.User;

/**
 * @author Tao
 * @create 2020/4/23 20:27
 */

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "index";
    }

    //只要接口返回值中存在实体类，就会被扫描到swagger的models
    @PostMapping("/user/{username}")
    @ApiOperation("新增hello用户")
    public User user(@ApiParam("用户名") @PathVariable("username") String username){
        return  new User(username,"123456");
    }
}
