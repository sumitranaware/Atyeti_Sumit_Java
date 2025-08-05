package com.example.Microservice_api_gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalLoggingFilter implements GlobalFilter , Ordered {
    public Mono<Void>filter(ServerWebExchange exchange, GatewayFilterChain chain){
        // pre filter
        log.info("Logging from global pre :{} ",exchange.getRequest().getURI());

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            log.info("Logging from global Post :{} ",exchange.getResponse().getStatusCode());
        }));
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
