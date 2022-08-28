package com.yun.service;

import com.yun.entity.SysUser;
import com.yun.vo.Result;
import com.yun.vo.params.LoginParams;

/**
 * @author : ljg
 * @date : 2022/5/21 11:12
 * @description :
 */
public interface LoginService {

    /**
     * 登录功能
     * @param loginParams
     * @return
     */
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册
     * @param loginParams
     * @return
     */
    Result register(LoginParams loginParams);
}
