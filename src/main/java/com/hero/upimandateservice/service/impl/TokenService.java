package com.hero.upimandateservice.service.impl;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.hero.upimandateservice.client.TokenClient;
import com.hero.upimandateservice.exception.ClientException;
import com.hero.upimandateservice.model.TokenRequest;
import com.hero.upimandateservice.model.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService  {
    Logger logger = LoggerFactory.getLogger(TokenService.class);

    @Value("${mandate.appID}")
    @JsonProperty("AppID")
    private String appId;

    @Value("${mandate.merchantKey}")
    @JsonProperty("MerchantKey")
    private String merchantKey;
    @Value("${yoeki.upimandate.accesstoken.url}")
    private String appUrl;

    private String accessToken;
    private long expiryTime;

    private final TokenClient tokenClient;

    public TokenService(TokenClient tokenClient) {
        this.tokenClient = tokenClient;
    }



    public synchronized String getToken(){
        if (accessToken==null || System.currentTimeMillis()>expiryTime){

            refreshToken();
        }
        return accessToken;
    }

//    @CircuitBreaker(name = "apiClientCircuitBreaker",fallbackMethod = "fallbackToken")
    private void refreshToken() {

        logger.info("startTime", String.valueOf(System.currentTimeMillis()));
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setAppId(appId);
        tokenRequest.setMerchantKey(merchantKey);
        try {
            TokenResponse tokenResponse = tokenClient.generateToken(tokenRequest);
            this.accessToken = tokenResponse.getAccessToken();
            this.expiryTime = System.currentTimeMillis() + (15 * 60 * 1000);

        }
        catch (Exception e){
            logger.error("Token generator error :: " +e.getMessage());
            throw new ClientException(500,e.getMessage());
        }

    }

//    private String fallbackToken(Throwable throwable){
//        if (throwable instanceof FeignClient){
//            FeignException feignException = (FeignException) throwable;
//            String string = feignException.contentUTF8();
//            return "Fallback ,Token API response : " +string;
//        }
//        return "Fallback ,Token API response " +throwable.getMessage();
//    }



//    private final RestTemplate restTemplate;
//    public TokenServiceImpl(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public String getToken(){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        JSONObject requestJsonObject = new JSONObject();
//        requestJsonObject.put("appId", appId);
//        requestJsonObject.put("merchantKey",merchantKey);
//        HttpEntity<String> httpEntity = new HttpEntity<>(requestJsonObject.toString(),httpHeaders);
//        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(appUrl, httpEntity, String.class);
//         return stringResponseEntity.getBody();
//    }
}
