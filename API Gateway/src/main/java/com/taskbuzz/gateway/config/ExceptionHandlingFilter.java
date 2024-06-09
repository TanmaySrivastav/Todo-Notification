package com.taskbuzz.gateway.config;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
@Order(-1)
public class ExceptionHandlingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange)
        		.timeout(java.time.Duration.ofMillis(10000)) // Global timeout for the entire request
                .onErrorResume(throwable -> handleException(exchange, throwable));
    }

    private Mono<Void> handleException(ServerWebExchange exchange, Throwable throwable) {
        if (throwable instanceof ResponseStatusException) {
        	exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
        	exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        	String errorMessage = "{ \"error\": \"Bad Request\" }";
        	DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(errorMessage.getBytes());
        	return exchange.getResponse().writeWith(Mono.just(buffer));
        } 
        else if (throwable instanceof java.util.concurrent.TimeoutException) {
            exchange.getResponse().setStatusCode(HttpStatus.GATEWAY_TIMEOUT);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        	String errorMessage = "{ \"error\": \"Request Timed Out\" }";
        	DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(errorMessage.getBytes());
        	return exchange.getResponse().writeWith(Mono.just(buffer));
        }
        else {
            exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        	String errorMessage = "{ \"error\": \"Internal Server Error\" }";
        	DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(errorMessage.getBytes());
        	return exchange.getResponse().writeWith(Mono.just(buffer));
        }
    }
}
