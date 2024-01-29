package com.hero.upimandateservice.controller;


import com.hero.upimandateservice.exception.UPIMandateResponseException;
import com.hero.upimandateservice.model.APILogger;
import com.hero.upimandateservice.model.UPIMandateRequest;
import com.hero.upimandateservice.model.VerifyVPARequest;
import com.hero.upimandateservice.service.impl.UPIMandateCreationServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    private static final Integer BAD_REQUEST = 400;
    private static final Integer INTERNAL_SERVER_ERROR = 500;

    private static final Integer OK = 200;

    private final UPIMandateCreationServiceImpl upiMandateCreationService;

    public UPIMandateController(UPIMandateCreationServiceImpl upiMandateCreationService) {
        this.upiMandateCreationService = upiMandateCreationService;

    }

    @PostMapping(value = "/upi/mandate",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createMandate(@RequestBody UPIMandateRequest upiMandateRequest) {
        APILogger log = new APILogger("/upi/mandate", upiMandateRequest.getAppID());
        String mandate;
        try {
            log.add("startTime", String.valueOf(System.currentTimeMillis()));
            mandate = upiMandateCreationService.createMandate(upiMandateRequest);
            log.add("endTime", String.valueOf(System.currentTimeMillis()));
            log.logSuccess(OK);

        }
        catch (HttpClientErrorException ex){
            log.logError(ex.getMessage(), BAD_REQUEST, ex);
            throw new UPIMandateResponseException(ex.getMessage());
        }
        catch (Exception exception){
            log.logError(exception.getMessage(), INTERNAL_SERVER_ERROR, exception);
            throw exception;
        }
        return new ResponseEntity<>(mandate, HttpStatus.OK);


    }

    //creating fallback method circuit breaker






    //web hook url


}
