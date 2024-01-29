//package com.hero.upimandateservice.auth;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//public class AuthKeyInterceptor implements HandlerInterceptor {
//    Logger logger = LoggerFactory.getLogger(AuthKeyInterceptor.class);
//
//    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
//
//    @Value("${efin.api-key}")
//    private String apiKey;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String requestHeader = request.getHeader(AUTH_TOKEN_HEADER_NAME);
//        logger.info("API key received :: " +requestHeader);
//        if (requestHeader==null || !requestHeader.equals(apiKey))
//        {
//            logger.warn("Invalid or missing api key {} " ,request.getRequestURI());
//            response.sendError(HttpStatus.UNAUTHORIZED.value(),"Invalid-api-key");
//            return false;
//        }
//        logger.info("Valid api key received {} ", request.getRequestURI());
//        return true;
//    }
//}
