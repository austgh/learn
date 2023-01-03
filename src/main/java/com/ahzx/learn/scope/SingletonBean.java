package com.ahzx.learn.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author think
 * @version 1.0
 * @date 2022/2/28 22:13
 * Spring中单例中如何注入原型
 * 1.使用ApplicationContext
 * 2.是使用@Lookup
 * 3.使用proxyMode = ScopedProxyMode.TARGET_CLASS
 */
@Component
public class SingletonBean {
    private static final Logger logger = LoggerFactory.getLogger(SingletonBean.class);
//    @Autowired
//    private PrototypeBean bean;
//    public void print() {
//        logger.info("Bean SingletonBean's HashCode : {}",bean.hashCode());
//        bean.say();
//    }
//    @Autowired
//    private ApplicationContext context;

    /**
     * 每次都从ApplicatonContext中获取新的bean引用
     *
     * @return PrototypeBean instance
     */
//    PrototypeBean getFromApplicationContext() {
//        return this.context.getBean("prototypeBean",PrototypeBean.class);
//    }
//    public void print() {
//        PrototypeBean bean = getFromApplicationContext();
//        logger.info("Bean PrototypeBean's HashCode : {}",bean.hashCode());
//        bean.say();
//    }
//     也可以写成 @Lookup("prototypeBean") 来指定需要注入的bean
//    @Lookup
//    protected abstract PrototypeBean methodInject();
    @Lookup("prototypeBean")
    protected PrototypeBean methodInject() {
        return null;
    }

    public void print() {
        PrototypeBean bean = methodInject();
        logger.info("Bean PrototypeBean's HashCode : {}", bean.hashCode());
        bean.say();
    }
//    <public|protected> [abstract] <return-type> theMethodName(no-arguments);
//    @Autowired
//    PrototypeBean prototypeBean;
//    public void print() {
////        PrototypeBean bean = methodInject();
//        logger.info("Bean PrototypeBean's HashCode : {}",prototypeBean.hashCode());
//        prototypeBean.say();
//    }
}
