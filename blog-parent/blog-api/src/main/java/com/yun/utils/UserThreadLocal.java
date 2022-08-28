package com.yun.utils;

import com.yun.entity.SysUser;

/**
 * @author : ljg
 * @date : 2022/5/22 20:09
 * @description :
 */
public class UserThreadLocal {

    private UserThreadLocal(){

    }

    private static final ThreadLocal<SysUser> LOCAL=new ThreadLocal<>();
    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }

}
