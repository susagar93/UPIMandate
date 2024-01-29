package com.hero.upimandateservice.client;


import com.hero.upimandateservice.model.UPIMandateRequest;
import com.hero.upimandateservice.model.UPIMandateResponse;
import com.hero.upimandateservice.model.VPAVerifyResponse;
import com.hero.upimandateservice.model.VerifyVPARequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(url = "https://hfcupiuat.zipnach.com:4664", value = "UPI-MANDATE-SERVICE",configuration = FeignClientInterceptor.class)
public interface UPIMandateClient {

//    @PostMapping("/api/createmandate")
//    String createUpiMandate(@RequestBody UPIMandateRequest upiMandateRequest);

    @PostMapping("/api/createmandate")
    @Headers("Accept:application/json")
    String createUpiMandate(@RequestBody UPIMandateRequest upiMandateRequest);

    @PostMapping("/api/VerifyVPA")
    VPAVerifyResponse verifyVPA(@RequestBody VerifyVPARequest verifyVPARequest);



}
