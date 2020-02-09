package com.tp.serviceribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tp.serviceribbon.service.RibbonHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * FileName: RibbonHiServiceImpl
 * Author:   TP
 * Date:     2019-10-27 18:15
 * Description:
 */
@Service
public class RibbonHiServiceImpl implements RibbonHiService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        // int i = 1 / 0; //测试服务降级
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "服务降级：sorry " + name + "服务暂不可用";
    }
}
