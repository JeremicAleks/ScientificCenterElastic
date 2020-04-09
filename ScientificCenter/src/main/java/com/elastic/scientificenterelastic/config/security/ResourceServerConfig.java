package com.elastic.scientificenterelastic.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource_id";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.anonymous().and().csrf().disable().authorizeRequests().antMatchers("/oauth/token").permitAll().anyRequest()
		http.anonymous().and().csrf().disable().authorizeRequests().antMatchers("/oauth/token", "/api","/**","**").permitAll().anyRequest()
				.authenticated().and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}
