package com.ahzx.learn.scope.circule.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/14 21:31
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.ahzx.learn.scope.circule")
@EnableAsync
public class AspectConfig {  //代理对象
}
