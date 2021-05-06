package org.example.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GageWayConfig
 * @Description TODO
 * @Date 2021/4/29 17:33
 * @Created by wangjianping
 */
@Configuration
public class GageWayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("guonei",r->r.path("/guonei").uri("https://news.baidu.com/guonei"))
                .route("guoji",r->r.path("/guoji").uri("https://news.baidu.com/guoji"))
                .build();
    }
}
