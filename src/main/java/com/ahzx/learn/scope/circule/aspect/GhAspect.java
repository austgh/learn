package com.ahzx.learn.scope.circule.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/14 20:23
 */
@Aspect
@Component
public class GhAspect {
    @Before("execution(public void com.ahzx.learn.scope.circule.service.AService.test())")
    public void ghBefore(JoinPoint joinPoint) {
        System.out.println("ghBefore");
    }

}
