package com.hero.upimandateservice.client;


import com.hero.upimandateservice.model.TokenRequest;
import com.hero.upimandateservice.model.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(url = "https://hfcupiuat.zipnach.com:4664", value = "TOKEN-SERVICE")
public interface TokenClient {

    @PostMapping("/api/TokenGenerator")
    TokenResponse generateToken(@RequestBody TokenRequest tokenRequest);

}
