package com.david.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.david.config.auth.PrincipalDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	private final PrincipalDetailService  principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorizeRequests ->
				authorizeRequests
					.requestMatchers("/","/auth/**","/js/**","/css/**","/image/**").permitAll()
					.anyRequest().authenticated()
			)
			.formLogin(formLogin ->
		        formLogin
		             .loginPage("/auth/user/login")
		             .defaultSuccessUrl("/")
		     )
		     .csrf(csrf -> csrf.disable());

		   return http.build();
		   
		   
		  
			}
	
		   
		   
	 }
	

	
	