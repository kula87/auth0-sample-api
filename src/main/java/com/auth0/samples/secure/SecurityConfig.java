package com.auth0.samples.secure;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()

                // Note: If passing an Authorization header, Spring Security will validate it even with permitAll()
                // You can ignore security filters if this is an issue for you, as discussed here:
                // https://stackoverflow.com/questions/36296869/spring-security-permitall-still-considering-token-passed-in-authorization-header
           		.antMatchers(HttpMethod.GET, "/api/createUser").permitAll()
          		.antMatchers(HttpMethod.GET, "/api/users").authenticated()
        		.antMatchers(HttpMethod.GET, "/api/private").authenticated();
 
    }
}