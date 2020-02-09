package com.tp.servicegateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * FileName: RateLimiterConfig
 * Author:   TP
 * Date:     2020-02-08 17:03
 * Description:网关路由限流配置
 */
@Configuration
public class RateLimiterConfig {

    /**
     * IP限流
     *
     * @return Key解析器
     */
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    /**
     * 用户限流
     * 使用这种方式限流，请求路径中必须携带userId参数
     *
     * @return Key解析器
     */
    // @Bean
    // KeyResolver userKeyResolver() {
    //     return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    // }

    /**
     * 接口限流
     * 获取请求地址的uri作为限流key
     *
     * @return
     */
    // @Bean
    // KeyResolver apiKeyResolver() {
    //     return exchange -> Mono.just(exchange.getRequest().getPath().value());
    // }


}

