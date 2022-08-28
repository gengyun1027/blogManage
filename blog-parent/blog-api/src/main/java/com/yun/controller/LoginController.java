package com.yun.controller;

import com.yun.service.LoginService;
import com.yun.vo.Result;
import com.yun.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ljg
 * @date : 2022/5/21 11:07
 * @description :
 */

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams) {
        return loginService.login(loginParams);
    }
}

