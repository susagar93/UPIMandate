package com.hero.upimandateservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyVPARequest {
    @JsonProperty("AppID")
    @Value("${mandate.appId}")
    private String appID;
    @JsonProperty("Merchantvpa")
    @Value("${mandate.merchantvpa}")
    private String merchantvpa;
    @JsonProperty("Customervpa")
    @Value("${mandate.customervpa}")
    private String customervpa;
    @JsonProperty("ReqCustName")
    private  String reqCustName;
}
