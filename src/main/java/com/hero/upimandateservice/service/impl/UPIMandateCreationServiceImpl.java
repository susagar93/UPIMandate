package com.hero.upimandateservice.service.impl;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.hero.upimandateservice.client.UPIMandateClient;
import com.hero.upimandateservice.encryption.AES256;
import com.hero.upimandateservice.exception.ClientException;
import com.hero.upimandateservice.exception.ServerException;
import com.hero.upimandateservice.exception.UPIMandateResponseException;
import com.hero.upimandateservice.model.UPIMandateRequest;
import com.hero.upimandateservice.model.VPAVerifyResponse;
import com.hero.upimandateservice.model.VerifyVPARequest;
import com.hero.upimandateservice.service.UPIMandateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;


@Service
public class UPIMandateCreationServiceImpl implements UPIMandateService {

    private static final String VPA_MISMATCH_MESSAGE = "VPAVerId is mismatch";

    private static final Integer BAD_REQUEST = 400;
    private static final Integer INTERNAL_SERVER_ERROR = 500;


    @Value("${mandate.appID}")
    @JsonProperty("AppID")
    private String appId;

    @Value("${mandate.merchantKey}")
    @JsonProperty("MerchantKey")
    private String merchantKey;
    @Value("${yoeki.upimandate.accesstoken.url}")
    private String appUrl;
    @Value("${mandate.merchantvpa}")
    private String merchantvpa;
    @Value("${mandate.customervpa}")
    private String customervpa;

    private final Gson gson;

    private final UPIMandateClient upiMandateClient;


    public UPIMandateCreationServiceImpl(Gson gson, UPIMandateClient upiMandateClient) {
        this.gson = gson;
        this.upiMandateClient = upiMandateClient;


    }

    // Mandate Creation
    @Override
//    @CircuitBreaker(name = "apiClientCircuitBreaker",fallbackMethod = "upiFallback")
    public String createMandate(UPIMandateRequest upiMandateRequest) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");


        try {
            VerifyVPARequest verifyVPARequest = VerifyVPARequest.
                    builder().
                    appID(appId).
                    merchantvpa(merchantvpa).
                    customervpa(customervpa).
                    reqCustName(upiMandateRequest.getReqCustName()).
                    build();

            // pass vpa json request to verify the vpa
            VPAVerifyResponse vpaVerifyResponse = upiMandateClient.verifyVPA(verifyVPARequest);

                try {
                    String encryptedEmail = AES256.encrypted(upiMandateRequest.getReqCustEmail());
                    String encryptedPhone = AES256.encrypted(upiMandateRequest.getReqCustPhone());
                    String encryptedReqAccNo = AES256.encrypted(upiMandateRequest.getReqAccNo());
                    String encryptedReqAmt = AES256.encrypted(upiMandateRequest.getReqAmt());
                    AES256.decrypted(encryptedReqAccNo);
                    AES256.decrypted(appId);
                    upiMandateRequest.setAppID(appId);
                    upiMandateRequest.setMerchantvpa(merchantvpa);
                    upiMandateRequest.setCustomervpa(customervpa);
                    upiMandateRequest.setReqCustEmail(encryptedEmail);
                    upiMandateRequest.setReqCustPhone(encryptedPhone);
                    upiMandateRequest.setReqAmt(encryptedReqAmt);
                    upiMandateRequest.setReqAccNo(encryptedReqAccNo);
                    upiMandateRequest.setVPAVerId(vpaVerifyResponse.getVPAVerId());
                    String upiMandate = upiMandateClient.createUpiMandate(upiMandateRequest);
                    return upiMandate;
                }catch (ClientException ex){
                    throw new ClientException(BAD_REQUEST,ex.getMessage());
                }




        }

        catch (UPIMandateResponseException ex) {
            throw new UPIMandateResponseException(VPA_MISMATCH_MESSAGE);

        }
        catch (Exception ex) {
            throw new ServerException(BAD_REQUEST,ex.getMessage());
        }

    }

//    private String upiFallback(Throwable throwable){
//        if (throwable instanceof FeignClient){
//            FeignException feignException = (FeignException) throwable;
//            String string = feignException.contentUTF8();
//            return "Fallback ,UPI Mandate API response : " +string;
//        }
//        return "Fallback ,UPI Mandate API response " +throwable.getMessage();
//    }


}
