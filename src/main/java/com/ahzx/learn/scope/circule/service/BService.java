package com.ahzx.learn.scope.circule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/14 20:22
 */
@Component
public class BService {
    @Autowired
    AService aService;

}
