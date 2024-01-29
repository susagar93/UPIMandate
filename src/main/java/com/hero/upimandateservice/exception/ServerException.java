package com.hero.upimandateservice.exception;

import lombok.Getter;

@Getter
public class ServerException extends RuntimeException{
    private int status;

    public ServerException(int status,String message) {
        super(message);
        this.status = status;
    }
}
