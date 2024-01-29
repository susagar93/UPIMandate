package com.hero.upimandateservice.auth;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;


import java.io.IOException;
import java.io.PrintWriter;


public class AuthenticationFilter extends GenericFilterBean {

    Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
 
	private String apiKey;
	public AuthenticationFilter(String apiKey) {
		this.apiKey = apiKey;
	}
    

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)

      throws IOException, ServletException {

        try {

            Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) request, apiKey);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("Authentication filter authenticate");

        } catch (Exception exp) {
            logger.error("Authencation Filter :: "+exp.getMessage());
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

            PrintWriter writer = httpResponse.getWriter();

            writer.print(exp.getMessage());

            writer.flush();

            writer.close();

        }

 

        filterChain.doFilter(request, response);

    }


}
