package com.niit.springcloudapigateway.config;

import com.niit.springcloudapigateway.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/**")
                        .uri("lb://user-authentication-service"))
                .route(p->p
                .path("/api/v2/user/**","/api/v2/register","/api/v3/**")
                        .uri("lb://user-movie-service"))
//                .route(p -> p
//                        .path("/api/v3/**")
//                        .uri("lb://user-movie-service"))
                .route(p -> p
                        .path("/api/v4/**")
                        .uri("lb://user-favourite-movie-service"))
                .build();
    }
    @Bean
    public FilterRegistrationBean jwtFilterBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/api/v2/user/*");
        return filterRegistrationBean;
    }
}




