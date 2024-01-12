package com.david.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.david.config.auth.PrincipalDetailService;

@Configuration
class AuthenticationManagerBuilderConfig {

    private final PrincipalDetailService principalDetailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthenticationManagerBuilderConfig(PrincipalDetailService principalDetailService,
                                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.principalDetailService = principalDetailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(principalDetailService)
            .passwordEncoder(bCryptPasswordEncoder);
    }
}