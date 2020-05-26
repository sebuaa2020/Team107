package com.example.system.tomcat.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("nmysl");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("nmysl");
    }
}
