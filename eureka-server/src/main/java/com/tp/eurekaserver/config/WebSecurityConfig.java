package com.tp.eurekaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * FileName: WebSecurityConfig
 * Author: TP
 * Date: 2020-02-06 19:10
 * Description: 添加一个WebSecurityConfig.java类
 * 因为新版的security默认启用了csrf检验，要在eureka-server服务端配置security的csrf检验为false，eureka-client才能注册，
 * 而且它还不支持在配置文件中配置
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}

