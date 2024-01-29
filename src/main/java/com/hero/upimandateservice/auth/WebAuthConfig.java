//package com.hero.upimandateservice.auth;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebAuthConfig implements WebMvcConfigurer {
//    Logger logger = LoggerFactory.getLogger(WebAuthConfig.class);
//
//    @Autowired
//    private final AuthKeyInterceptor authKeyInterceptor;
//
//    public WebAuthConfig(AuthKeyInterceptor authKeyInterceptor) {
//        this.authKeyInterceptor = authKeyInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        logger.info("addIntercepotor {} ", authKeyInterceptor);
//        registry.addInterceptor(authKeyInterceptor).addPathPatterns("/api/upi/*");
//    }
//}
