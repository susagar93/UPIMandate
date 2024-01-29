package com.hero.upimandateservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class TokenResponse {

    @JsonProperty("Token")
    private String accessToken;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Expiresin")
    private String expireIn;
    @JsonProperty("Issued")
    private String issued;
    @JsonProperty("Expires")
    private String expires;
}
