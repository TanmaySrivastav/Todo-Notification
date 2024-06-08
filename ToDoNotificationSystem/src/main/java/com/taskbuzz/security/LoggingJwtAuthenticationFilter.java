package com.taskbuzz.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingJwtAuthenticationFilter extends JwtAuthenticationFilter {
    private final JwtAuthenticationFilter decoratedFilter;
    private Logger logger = LoggerFactory.getLogger(LoggingJwtAuthenticationFilter.class);

    public LoggingJwtAuthenticationFilter(JwtAuthenticationFilter decoratedFilter) {
        this.decoratedFilter = decoratedFilter;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Add logging logic here before delegating to the decorated filter
        logger.info("Logging: Request received at LoggingJwtAuthenticationFilterDecorator");

        // Call the decorated filter's doFilterInternal method
        decoratedFilter.doFilterInternal(request, response, filterChain);

        // Add logging logic here after the decorated filter
        logger.info("Logging: Request processed at LoggingJwtAuthenticationFilterDecorator");
    }
}