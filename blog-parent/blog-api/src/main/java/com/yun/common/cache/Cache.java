package com.yun.common.cache;

import java.lang.annotation.*;

/**
 * @author : ljg
 * @date : 2022/5/28 21:04
 * @description :
 */
//type 代表可以放在类上，method 代表可以放在方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 1 * 60 * 1000;

    //缓存标识key
    String name() default "";
}
