package com.hero.upimandateservice.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRequest {
    @JsonProperty("Message")
    private String message;
    @JsonProperty("ResCode")
    private String resCode;
}
