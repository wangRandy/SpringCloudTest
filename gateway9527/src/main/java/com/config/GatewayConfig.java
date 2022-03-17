package com.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
   /* @Bean
    public RouteLocator BlogRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder=routeLocatorBuilder.routes();
        builder.route("blog_route",//id
                r -> r.path("/randycout")//访问http://localhost:9527/randycout
                .uri("http://randycout.com"));
        builder.route("path_route_angenin2",  //id
                r -> r.path("/guoji")  //访问 http://localhost:9527/guoji
                        .uri("http://news.baidu.com/guoji"));  //就会转发到 http://news.baidu.com/guonji
        return builder.build();
    }
*/
}
