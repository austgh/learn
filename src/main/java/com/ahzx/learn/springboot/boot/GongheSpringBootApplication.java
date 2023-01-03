package com.ahzx.learn.springboot.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/18 6:42
 */
@ComponentScan
@Documented
@Inherited
@Configuration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GongheSpringBootApplication {
}
