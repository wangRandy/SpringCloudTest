package com.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogFilter implements GlobalFilter, Ordered {//全局过滤器
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("这是我自定义的日志过滤器:"+new Date());
        //获取request中的uname参数
       String uname= exchange.getRequest().getQueryParams().getFirst("uname");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (uname == null) {
            log.info("用户名为空,是非法用户");
            //设置响应不接受
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //返回值是过滤器的优先级,越小优先级越高
        return 0;
    }
}
