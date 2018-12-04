package com.lindacare.studentgrade.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import com.lindacare.studentgrade.controller.StudentGradesController;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Value(value = "${auth0.apiAudience}")
	private String apiAudience;
	@Value(value = "${auth0.issuer}")
	private String issuer;

	Logger logger = LoggerFactory.getLogger(StudentGradesController.class);
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("############## apiAudience: '" + apiAudience + "' issuer: '" + issuer + "'");	
		JwtWebSecurityConfigurer
	        .forRS256(apiAudience, issuer)
	        .configure(http)
	        .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/api/v1/studentgrades").permitAll()
	        .antMatchers(HttpMethod.GET, "/api/v1/studentgrades").hasAuthority("read:studentgrades")
	        .antMatchers(HttpMethod.GET, "/api/v1/studentgrades/studentIdCard/**").hasAuthority("read:studentgrade")
	        .anyRequest().authenticated();
	}
}

