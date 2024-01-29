package com.hero.upimandateservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VPAVerifyResponse {
    @JsonProperty("Message")
    public String message;
    @JsonProperty("ResCode")
    public String resCode;
    @JsonProperty("ReqCustName")
    public String reqCustName;
    @JsonProperty("ResCustName")
    public String resCustName;
    @JsonProperty("VPAVerId")
    public String vPAVerId;
    @JsonProperty("PerMatch")
    public int perMatch;
}
