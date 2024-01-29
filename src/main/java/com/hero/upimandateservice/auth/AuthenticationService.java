package com.hero.upimandateservice.auth;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;




public class AuthenticationService {

    Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";


 

    public static Authentication getAuthentication(HttpServletRequest request, String configureApiKey) {

        String uri = request.getRequestURI();

        boolean healthcheck = "/".equals(uri) || "/upi/mandate".equals(uri) || "/upi/mandate/".equals(uri);


        if (healthcheck) {

            return new ApiKeyAuthentication("healthcheck", AuthorityUtils.NO_AUTHORITIES);

        }

        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

        if (apiKey == null || !apiKey.equals(configureApiKey)) {

            throw new BadCredentialsException("Invalid API Key");

        }

 

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);

    }

}