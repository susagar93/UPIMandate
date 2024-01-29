package com.hero.upimandateservice.exception;

import lombok.Getter;

@Getter
public class ClientException extends RuntimeException{

    private int statusCode;

    public ClientException( int statusCode,String message) {
        super(message);
        this.statusCode = statusCode;
    }


}
