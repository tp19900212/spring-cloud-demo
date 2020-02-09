package com.tp.servicezuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileName: MyFallbackProvider
 * Author:   TP
 * Date:     2020-02-08 10:43
 * Description:在Zuul中实现熔断功能需要实现FallbackProvider接口，并实现getRoute()和fallbackResponse()方法
 * getRoute()方法用于指定熔断功能应用于哪些路由的服务
 * fallbackResponse()方法用于指定进入熔断功能时执行的逻辑
 */
@Component
public class MyFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        //配置所有路由服务都加熔断功能，如果指定某个路由服务实现熔断功能，返回对应服务的serviceId
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("sorry! error, I'm the fallback.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
