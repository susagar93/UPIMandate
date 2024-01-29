package com.hero.upimandateservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UPIMandateRequest {
    @JsonProperty("AppID")
    @Value("${mandate.appID}")
    private String appID;
    @JsonProperty("Merchantvpa")
    @Value("${mandate.merchantvpa}")
    private String merchantvpa;
    @JsonProperty("Customervpa")
    @Value("${mandate.customervpa}")
    private String customervpa;
    @JsonProperty("ReqAmt")
    private String reqAmt;
    @JsonProperty("DType")
    private String dType;
    @JsonProperty("ReqRefNum")
    @Value("${mandate.reqRefNum}")
    private String reqRefNum;
    @JsonProperty("ReqCustPhone")
    private String reqCustPhone;
    @JsonProperty("ReqCustEmail")
    private String reqCustEmail;
    @JsonProperty("PFrom")
    private String pFrom;
    @JsonProperty("PTo")
    private String pTo;
    @JsonProperty("ReqCustName")
    private  String reqCustName;
    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("BranchId")
    private String branchId;
    @JsonProperty("ReqAccNo")
    private String reqAccNo;
    @JsonProperty("ReqAccValidate")
    private String reqAccValidate;
    @JsonProperty("ReqAutoRevoke")
    private String reqAutoRevoke;
    @JsonProperty("VPAVerId")
    private String vPAVerId;
}
