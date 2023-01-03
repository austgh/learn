package com.ahzx.learn.springboot.boot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/18 6:41
 */
public class GongheSpringApplication {
    public static ConfigurableApplicationContext run(Class config) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(config);
        applicationContext.refresh();
        startTomcat(applicationContext);
        return applicationContext;
    }

    private static Tomcat startTomcat(AnnotationConfigWebApplicationContext applicationContext) {
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");
        Connector connector = new Connector();
        connector.setPort(8081);
        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");
        Host host = new StandardHost();
        host.setName("localhost");
        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        host.addChild(context);
        engine.addChild(host);
        service.setContainer(engine);
        service.addConnector(connector);
//        DispatcherServlet dispatcherServlet = applicationContext.getBean(DispatcherServlet.class);
//        tomcat.addServlet(contextPath, "dispatcher", dispatcherServlet);
        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(applicationContext));
        context.addServletMappingDecoded("/*", "dispatcher");
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return tomcat;
    }
}
