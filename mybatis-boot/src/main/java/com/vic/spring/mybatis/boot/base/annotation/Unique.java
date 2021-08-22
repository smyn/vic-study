package com.vic.spring.mybatis.boot.base.annotation;

import java.lang.annotation.*;

/**
 * define unique index
 * @author vic
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface Unique {
    String value() default "";
}
