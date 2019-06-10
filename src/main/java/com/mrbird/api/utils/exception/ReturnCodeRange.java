package com.mrbird.api.utils.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 错误返回码范围
 * @author chenyao
 * @date 2018/10/26.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ReturnCodeRange {
    int min();
    int max();
    String prefix();

}
