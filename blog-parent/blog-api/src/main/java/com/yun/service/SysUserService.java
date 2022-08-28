package com.yun.service;

import com.yun.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljg
 * @since 2022-05-19
 */
public interface SysUserService extends IService<SysUser> {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    /**
     * 根据账户查找用户
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);
}
