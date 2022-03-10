package com.ahzx.learn.scope.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author think
 * @version 1.0
 * @date 2022/2/28 23:14
 */
public class MySingletonBean {
    private static final Logger logger = LoggerFactory.getLogger(MySingletonBean.class);
    @Autowired
    private MyPrototypeBean myPrototypeBean;

    public void showMessage(){
        logger.info("myPrototypeBean1 hashcode:{}",myPrototypeBean.hashCode());
        logger.info("Hi, the time is {}",myPrototypeBean.getDateTime());
    }
}
