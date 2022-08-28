package com.yun.handler;

import com.alibaba.fastjson.JSON;
import com.yun.entity.SysUser;
import com.yun.service.LoginService;
import com.yun.utils.UserThreadLocal;
import com.yun.vo.ErrorCode;
import com.yun.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author : ljg
 * @date : 2022/5/22 13:46
 * @description : 拦截器
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在执行controller方法之前执行
        /**
         * 1. 需要判断请求的接口路径 是否为HandlerMethod(controller方法)
         * 2. 判断token是否为空，如果为空 未登录
         * 3. 如果token不空，登录验证loginService checkToken
         * 4. 如果认证成功 放行
         */
        if (!(handler instanceof HandlerMethod)) {
            //handler 可能是RequestResourceHandler springboot 程序 访问静态资源默认去classpath下static目录去查询
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("=============request start===============");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}",token);
        log.info("=============request end===============");

        if (StringUtils.isBlank(token)) {
            Result result = Result.fail(ErrorCode.NOT_LOGIN.getCode(), ErrorCode.NOT_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(JSON.toJSONString(result));
            return  false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if(sysUser==null){
            Result result = Result.fail(ErrorCode.NOT_LOGIN.getCode(), ErrorCode.NOT_LOGIN.getMsg());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(JSON.toJSONString(result));
            return  false;
        }
        //登录成功，放行
        //如何在controller中直接获取用户信息 怎么获取？
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除ThreadLocal，会有内存泄露的风险
        UserThreadLocal.remove();
    }
}
