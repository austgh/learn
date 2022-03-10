package com.ahzx.learn.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author think
 * @version 1.0
 * @date 2022/2/28 22:11
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    private static final Logger logger= LoggerFactory.getLogger(PrototypeBean.class);

    public void say() {
        logger.info("say something...");
    }
}
