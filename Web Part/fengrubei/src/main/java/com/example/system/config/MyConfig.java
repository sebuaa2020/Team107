package com.example.system.config;

import com.example.system.Interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSession;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    HttpSession session;

    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/index").setViewName("index");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginHandlerInterceptor)
//                .addPathPatterns("/index", "/")
//                .excludePathPatterns("/login", "/user/login","/assets/**","/data/**",);

    }
//
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index").setViewName("index");
//                registry.addViewController("/login").setViewName("login");
//                registry.addViewController("/project").setViewName("ui-pagination");
//                //registry.addViewController("/main.html").setViewName("index");
//            }
//
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //registry.addInterceptor(new LoginHandlerInterceptor())
//                //        .addPathPatterns("/index","/");
//                        //.excludePathPatterns("/login","/user/login");
//            }
//        };
//        return webMvcConfigurer;
//    }

}
