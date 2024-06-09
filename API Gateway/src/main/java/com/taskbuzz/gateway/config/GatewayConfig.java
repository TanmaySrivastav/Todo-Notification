package com.taskbuzz.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("USER_AND_TASK_MANAGEMENT_SERVICE", r -> r.path("/todos/**", "/auth/**", "/users/**")
				.uri("lb://ToDoAndUserManagementService"))
			.route("NOTIFICATION_SERVICE", r -> r.path("/notification/**")
			.uri("lb://ToDoNotificationService"))
			.build();
	}
}
