package com.ahzx.learn.scope.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author think
 * @version 1.0
 * @date 2022/2/28 23:13
 */
public class MyPrototypeBean {
    private static final Logger logger = LoggerFactory.getLogger(MyPrototypeBean.class);
    private String dateTimeString = LocalDateTime.now().toString();

    public String getDateTime() {
        logger.info("myPrototypeBean2 hashcode:{}",this.hashCode());
        return dateTimeString;
    }
}
