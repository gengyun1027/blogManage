package com.yun.common.aop;

import java.lang.annotation.*;

/**
 * @author : ljg
 * @date : 2022/5/26 14:17
 * @description :
 */
//type 代表可以放在类上，method 代表可以放在方法上
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String module() default "";
    String operator() default "";
}
