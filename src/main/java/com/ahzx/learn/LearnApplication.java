package com.ahzx.learn;

import com.ahzx.learn.scope.SingletonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearnApplication {
    private static final Logger logger = LoggerFactory.getLogger(LearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(final SingletonBean bean) {
        return (args) -> {
            logger.info("测试单例bean和原型bean的调用");
            int i = 0;
            while (i < 3) {
                i++;
                bean.print();
            }
        };
    }
}
