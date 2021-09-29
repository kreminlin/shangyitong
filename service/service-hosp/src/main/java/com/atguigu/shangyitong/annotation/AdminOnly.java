package com.atguigu.shangyitong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 配置annotation注解，在方法体或类上使用，从而实现切面效果
 * @author LiuShuo
 */
@Retention(RetentionPolicy.RUNTIME)//运行时在哪个时期
@Target(ElementType.METHOD)//声明注解在方法上使用
public @interface AdminOnly {
}
