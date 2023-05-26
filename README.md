# ROUTAGE STATIQUE AVEC SPRING CLOUD GATEWAY

## 3 méthodes pour faire un routage statiques :
- [x]  Avec un @Bean
- [x]  Avec application.propreties
- [x]  Avec application.yaml

## Avec un @Bean
```java
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("r1", r -> r
						.path("/api01/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://APIREST01"))
				.route("r2", r -> r
						.path("/api02/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://APIREST02"))
				.build();
	}
```
<br>

## Avec application.propreties
```js
spring.cloud.gateway.routes[0].id=api1_route
spring.cloud.gateway.routes[0].uri=http://localhost:8081
spring.cloud.gateway.routes[0].predicates[0]=Path=/api1/**
spring.cloud.gateway.routes[0].filters[0]=StripPrefix=1

spring.cloud.gateway.routes[1].id=api2_route
spring.cloud.gateway.routes[1].uri=http://localhost:8082
spring.cloud.gateway.routes[1].predicates[0]=Path=/api2/**
spring.cloud.gateway.routes[1].filters[0]=StripPrefix=1
```
<br>
## Avec application.yml

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: api1_route
          uri: http://localhost:8081
          predicates:
            - Path=/api1/**
          filters:
            - StripPrefix=1
        - id: api2_route
          uri: http://localhost:8082
          predicates:
            - Path=/api2/**
          filters:
            - StripPrefix=1
```

<br>
<div align="center">
  <img src="https://github.com/hpipou/Routage_Statique_SPRING_GATEWAY/blob/main/routagestatique.jpg"/><br>
</div>

<br>
<hr>
<br>
## @LAMINE 😉
