package com.yun.controller;

import com.yun.entity.SysUser;
import com.yun.utils.UserThreadLocal;
import com.yun.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ljg
 * @date : 2022/5/22 17:17
 * @description :
 */
@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
