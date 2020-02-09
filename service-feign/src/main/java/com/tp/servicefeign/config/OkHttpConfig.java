package com.tp.servicefeign.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * FileName: OkHttpConfig
 * Author:   TP
 * Date:     2020-02-06 22:02
 * Description:配置OkHttp与连接池，创建5个线程，保持5分钟长连接
 */

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class OkHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                //设置连接超时
                .connectTimeout(3, TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(3, TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(3, TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(5, 5L, TimeUnit.MINUTES))
                .build();
    }
}
