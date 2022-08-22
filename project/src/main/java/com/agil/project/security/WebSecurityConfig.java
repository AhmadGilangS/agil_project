package com.agil.project.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
	      http 
	      .cors().and()
	      .csrf().disable()
	      .authorizeRequests().antMatchers("/register**")
	      .permitAll() .anyRequest().authenticated() 
	      .and() 
	      .formLogin() .loginPage("/login")
	      .permitAll() 
	      .and() 
	      .logout() .invalidateHttpSession(true) 
	      .clearAuthentication(true) .permitAll(); 
	   }
}
