package com.hero.upimandateservice.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApiKeyAuthentication extends AbstractAuthenticationToken {
	Logger logger = LoggerFactory.getLogger(ApiKeyAuthentication.class);

	private final String apiKey;

	public ApiKeyAuthentication(String apiKey, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.apiKey = apiKey;
		setAuthenticated(true);

	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override

	public Object getPrincipal() {
		return apiKey;

	}

}
