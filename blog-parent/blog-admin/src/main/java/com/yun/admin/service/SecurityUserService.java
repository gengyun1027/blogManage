package com.yun.admin.service;

import com.yun.admin.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author : ljg
 * @date : 2022/5/30 10:09
 * @description :
 */
@Component
public class SecurityUserService implements UserDetailsService {
    @Autowired
    private AdminService  adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //登录时，将username传递到这里
        //通过username查询admin表，如果admin存在，将密码告诉spring security
        //如果不存在，返回null 认证失败
        Admin admin = adminService.findAdminByUsername(username);
        if(admin==null){
            //登录失败
            return null;
        }
        UserDetails userDetails=new User(username,admin.getPassword(),new ArrayList<>());
        return userDetails;
    }
}
