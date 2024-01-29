package com.hero.upimandateservice.exception;

import com.hero.upimandateservice.auth.AuthKeyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandling.class);

    @ExceptionHandler(UPIMandateResponseException.class)
    public ResponseEntity<Object> handleHttpResponse(UPIMandateResponseException exception){
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("message", exception.getMessage());
        logger.error("Handle UPIMandateResponseException {} ",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<String> clientException(ClientException exception) {
        logger.error("Handle clientException {} ",exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(exception.getMessage());
    }
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<String> serverException(ServerException exception){
        logger.error("Handle serverException {} ",exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception exception){
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("message", exception.getMessage());
        logger.error("Handle handleAllException {} ",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
