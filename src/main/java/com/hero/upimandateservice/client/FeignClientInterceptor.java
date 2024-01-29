package com.hero.upimandateservice.client;

import com.hero.upimandateservice.service.impl.TokenService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor{



    @Autowired
    private TokenService tokenService;



    @Override
    public void apply(RequestTemplate requestTemplate) {
        String serviceToken = tokenService.getToken();
        requestTemplate.header("Authorization","Bearer " + serviceToken);
        requestTemplate.header("Content-type:application/json");
    }
}
