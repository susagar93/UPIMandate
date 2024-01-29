package com.hero.upimandateservice.controller;


import com.hero.upimandateservice.exception.UPIMandateResponseException;
import com.hero.upimandateservice.model.UPIMandateRequest;
import com.hero.upimandateservice.model.VerifyVPARequest;
import com.hero.upimandateservice.service.impl.UPIMandateCreationServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api")
//@Tag(name = "UPIMandateController" ,description = "This is UPI Mandate API")
public class UPIMandateController {

    private final UPIMandateCreationServiceImpl upiMandateCreationService;

    public UPIMandateController(UPIMandateCreationServiceImpl upiMandateCreationService) {
        this.upiMandateCreationService = upiMandateCreationService;

    }

    @PostMapping("/upi/mandate")
    public ResponseEntity<String> createMandate(@RequestBody UPIMandateRequest upiMandateRequest) {
        String mandate;
        try {
            mandate = upiMandateCreationService.createMandate(upiMandateRequest);
        }
        catch (HttpClientErrorException ex){
            throw new UPIMandateResponseException(ex.getMessage());
        }
        catch (Exception exception){
            throw exception;
        }
        return new ResponseEntity<>(mandate, HttpStatus.OK);


    }

    //creating fallback method circuit breaker






    //web hook url


}
