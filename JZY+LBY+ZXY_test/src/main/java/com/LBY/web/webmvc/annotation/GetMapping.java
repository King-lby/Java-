package com.LBY.web.webmvc.annotation;

import java.lang.annotation.*;

/**

 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GetMapping {
    String value() default "";
}
