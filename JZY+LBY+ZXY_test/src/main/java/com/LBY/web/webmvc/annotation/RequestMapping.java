package com.LBY.web.webmvc.annotation;

import com.LBY.web.webmvc.entity.RequestMethod;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";

    RequestMethod[] method() default {};
}
