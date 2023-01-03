package com.ahzx.learn.scope.circule;

import com.ahzx.learn.scope.circule.aspect.AspectConfig;
import com.ahzx.learn.scope.circule.service.AService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/15 11:03
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AspectConfig.class);
        AService aService = (AService) applicationContext.getBean("AService");
        aService.test();
    }

}
