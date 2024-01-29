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
public class UPIMandateResponse {
    @JsonProperty("Message")
    private String message;
    @JsonProperty("ResCode")
    private String resCode;
    @JsonProperty("MdtID")
    private String mdtID;
    @JsonProperty("ReqRefNum")
    private String reqRefNum;
    @JsonProperty("TxnID")
    private String txnID;
    @JsonProperty("VPAVerId")
    private String vPAVerId;
    @JsonProperty("ReqCustName")
    private String reqCustName;
    @JsonProperty("ResCustName")
    private String resCustName;
    @JsonProperty("PerMatch")
    private String perMatch;
    @JsonProperty("ResRejectReason")
    private String resRejectReason;
}
