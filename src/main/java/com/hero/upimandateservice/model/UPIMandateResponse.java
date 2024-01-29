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
    public String message;
    @JsonProperty("ResCode")
    public String resCode;
    @JsonProperty("MdtID")
    public String mdtID;
    @JsonProperty("ReqRefNum")
    public String reqRefNum;
    @JsonProperty("TxnID")
    public String txnID;
    @JsonProperty("VPAVerId")
    public String vPAVerId;
    @JsonProperty("ReqCustName")
    public String reqCustName;
    @JsonProperty("ResCustName")
    public String resCustName;
    @JsonProperty("PerMatch")
    public String perMatch;
    @JsonProperty("ResRejectReason")
    public String resRejectReason;
}
