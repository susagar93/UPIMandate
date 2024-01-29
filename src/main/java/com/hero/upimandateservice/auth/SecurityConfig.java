//package com.hero.upimandateservice.auth;
//
//import com.hero.upimandateservice.exception.UPIMandateResponseException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        try {
//            httpSecurity.csrf(csrf->csrf.disable()).
//                    httpBasic(httpBasic->httpBasic.disable())
//                    .authorizeHttpRequests(auth->auth.anyRequest().authenticated());
//
//            return httpSecurity.build();
//        }catch (Exception e){
//            logger.error("Seccuity Config Error :: "+e.getMessage());
//            throw new Exception(e.getMessage());
//        }
//
//
//
//    }
//}
