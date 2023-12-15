package com.umass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.umass.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	@Qualifier("CustomUserDetailsService")
	private CustomUserDetailsService userDetailsService;
	   @Bean 
	   public PasswordEncoder passwordEncoder() { 
	      return new BCryptPasswordEncoder(); 
	   } 
	   
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	 http 
         .csrf().disable()
//         .authorizeRequests().requestMatchers("/","/public/**", "/public/api/*")
//         .authorizeRequests().requestMatchers("/public/api/*", "/swagger-ui.html","/swagger-ui/index.html",
//        		 "/signup.html","/v3/api-docs",
//        		 "/scripts/*", "/styles/*", "/images/*")
         .authorizeRequests().requestMatchers("/*","/**")
         .permitAll()
         .and() 
         .authorizeRequests().requestMatchers("/private/**","/private/*")
         .permitAll().anyRequest().authenticated()
         .and() 
         .formLogin() .loginPage("/login").defaultSuccessUrl("/private/home")
         .permitAll() 
         .and() 
         .logout().invalidateHttpSession(true) 
         .clearAuthentication(true).permitAll(); 
    	 
    	 return http.build();
	}

}
