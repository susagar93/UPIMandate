package com.hero.upimandateservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        if (response.status()>=400 && response.status()<=499){
            String responseBody = getResponseBody(response);
            return new ClientException(response.status(),responseBody);
        }
        if (response.status()>=500 && response.status()<=599){
            String responseBody = getResponseBody(response);
            return new ClientException(response.status(),responseBody);
        }

        return errorDecoder.decode(s,response);
    }

    private String getResponseBody(Response response){
        if (response.body() !=null){
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(response.body().asInputStream(), StandardCharsets.UTF_8))) {
                return reader.lines().collect(Collectors.joining("\n"));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }
}
