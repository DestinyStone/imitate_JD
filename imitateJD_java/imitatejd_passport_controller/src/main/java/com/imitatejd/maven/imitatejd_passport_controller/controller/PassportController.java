package com.imitatejd.maven.imitatejd_passport_controller.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import response.Message;
import response.type.ResponseCodeType;
import utils.JwtUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/9 14:16
 * @Description: 用户登录，权限等相关
 */

@RestController
@CrossOrigin
public class PassportController {

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Message login(String username, String password, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username, password));
        String token = JwtUtil.createToken(username);
        response.setHeader("token", token);
        return new Message(ResponseCodeType.SUCCESS, "登录成功", true);
    }

    @ApiOperation("查询用户登录状态")
    @GetMapping("/loginStatus")
    public Message loginStatus() {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            return new Message(ResponseCodeType.LOGIN_STATUS, "用户已登录", true);
        } else {
            return new Message(ResponseCodeType.NO_LOGIN_STATUS, "用户未登录", true);
        }
    }

    @GetMapping("/unauthorized/{message}")
    public Message unauthorized(@PathVariable("message") String message) {
        System.out.println("333333");
        return new Message(ResponseCodeType.NO_LOGIN_STATUS, "用户未登录", true);
    }

}
