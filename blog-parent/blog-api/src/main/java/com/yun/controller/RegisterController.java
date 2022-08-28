package com.yun.controller;

import com.yun.service.LoginService;
import com.yun.vo.Result;
import com.yun.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author : ljg
 * @date : 2022/5/22 10:14
 * @description :
 */

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParams loginParams){
        //sso单点登录，如果把登录注册功能提出去（单独的服务，可以独立提供接口服务）
        return loginService.register(loginParams);
    }
}
