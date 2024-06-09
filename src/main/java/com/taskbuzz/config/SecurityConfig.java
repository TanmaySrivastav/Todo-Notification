package com.taskbuzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.taskbuzz.security.JwtAuthenticationEntryPoint;
import com.taskbuzz.security.JwtAuthenticationFilter;
import com.taskbuzz.security.LoggingJwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	    @Autowired
	    private JwtAuthenticationEntryPoint point;
	    @Autowired
	    private JwtAuthenticationFilter filter;
	    
	    @Autowired
	    private UserDetailsService userDetailsService;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
//	    @Bean
//	    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//	        return new JwtAuthenticationFilter();
//	    }

	    @Bean
	    public LoggingJwtAuthenticationFilter loggingJwtAuthenticationFilterDecorator(JwtAuthenticationFilter jwtAuthenticationFilter) {
	        return new LoggingJwtAuthenticationFilter(jwtAuthenticationFilter);
	    }
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(auth->auth.requestMatchers("/home/**")
	                		.authenticated().requestMatchers("/auth/login").permitAll().requestMatchers("/users/create-user")
	                		.permitAll().requestMatchers("/users/allusers").permitAll()
	                		.requestMatchers("/Todo/todos/{todoId}").permitAll()
	                		.anyRequest().authenticated())
	                		.exceptionHandling(ex -> ex.authenticationEntryPoint(point)).
	                		sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	                
	       // http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        
	     // Add the LoggingJwtAuthenticationFilterDecorator to the filter chain
	        http.addFilterBefore(loggingJwtAuthenticationFilterDecorator(filter), UsernamePasswordAuthenticationFilter.class);
	        
	        return http.build();
	    }
	    
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider	=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
	    return daoAuthenticationProvider; 
	    }

}
