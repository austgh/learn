package com.ahzx.learn.scope.circule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/14 20:22
 */
@Component
public class AService {
    @Lazy
    @Autowired
    BService bService;

    @Async
    public void test() {
        System.out.println(bService);
    }

}
