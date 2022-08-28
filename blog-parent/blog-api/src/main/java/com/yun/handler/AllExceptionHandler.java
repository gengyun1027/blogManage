package com.yun.handler;

import com.yun.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : ljg
 * @date : 2022/5/20 9:21
 * @description : 对加了controller的注解方法进行拦截处理AOP实现
 */
@ControllerAdvice
public class AllExceptionHandler {
    /**
     * 进行异常处理，处理Exception.class的异常
     * 必须使用ResponseBody返回json数据，否则返回页面
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception ex) {
        ex.printStackTrace();
        return Result.fail(-999, "系统异常");
    }
}
