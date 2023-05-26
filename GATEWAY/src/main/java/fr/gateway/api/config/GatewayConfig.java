package fr.gateway.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api1/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8081"))
                .route(r -> r.path("/api2/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8082"))
                .build();
    }

}