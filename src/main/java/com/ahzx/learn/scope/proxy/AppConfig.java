package com.ahzx.learn.scope.proxy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author think
 * @version 1.0
 * @date 2022/2/28 23:14
 */
@Configuration
public class AppConfig {
    /**
     *
     * proxyMode = ScopedProxyMode.TARGET_CLASS
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MyPrototypeBean myPrototypeBean () {
        return new MyPrototypeBean();
    }

    @Bean
    public MySingletonBean mySingletonBean () {
        return new MySingletonBean();
    }

    public static void main (String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MySingletonBean bean = context.getBean(MySingletonBean.class);
        bean.showMessage();
        Thread.sleep(1000);

        bean.showMessage();
    }
}
