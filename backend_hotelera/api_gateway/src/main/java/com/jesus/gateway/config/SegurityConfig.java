package com.jesus.gateway.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
public class SegurityConfig {

	@Bean
	SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.csrf(csrf->csrf.disable()
				.cors(cors->cors.configurationSource(request->{
					CorsConfiguration configuration = new CorsConfiguration();
					configuration.setAllowedOrigins(List.of("http://localhost:4200"));
					configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
					configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
					configuration.setAllowCredentials(true);
					return configuration;
				})).authorizeExchange(exchange->exchange
						.pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.pathMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN", "USER")
						.pathMatchers(HttpMethod.POST,"/**").hasAnyRole("ADMIN", "USER")
						.pathMatchers(HttpMethod.PUT,"/**").hasRole("ADMIN")
						.pathMatchers(HttpMethod.DELETE,"/**").hasRole("ADMIN")
						.anyExchange().authenticated())
				.oauth2ResourceServer(oauth2->oauth2.jwt(jwt->
				jwt.jwtAuthenticationConverter(reactiveJwtAuthenticationConverterAdapter()))));
		return http.build();
	}
	
	@Bean
	ReactiveJwtAuthenticationConverterAdapter reactiveJwtAuthenticationConverterAdapter() {
	    JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
	    grantedAuthoritiesConverter.setAuthoritiesClaimName("roles"); // el claim en tu token
	    grantedAuthoritiesConverter.setAuthorityPrefix(""); // ya viene con ROLE_

	    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
	    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
	    return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
	}
	
}
