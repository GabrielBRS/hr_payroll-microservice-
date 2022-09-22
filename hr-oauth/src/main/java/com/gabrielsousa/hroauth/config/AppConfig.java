package com.gabrielsousa.hroauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;


@Configuration
public class AppConfig
//implements Converter<Jwt, AbstractAuthenticationToken> 
{

//	private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
	}
	
	@Bean
	public TokenStore tokenStore() {
		
	}
	

//	@Override
//	public AbstractAuthenticationToken convert(Jwt source) {
//		JwtBearerTokenAuthenticationConverter tokenAuthenticationConverter = new JwtBearerTokenAuthenticationConverter();
//		tokenAuthenticationConverter.
//		return null;
//	}
	
}
