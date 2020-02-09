package com.tp.servicegateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: DefaultHystrixController
 * Author:   TP
 * Date:     2020-02-08 16:01
 * Description:默认降级处理
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultFallback")
    public Map<String, String> defaultfallback() {
        System.out.println("降级操作...");
        Map<String, String> map = new HashMap<>();
        map.put("resultCode", "500");
        map.put("resultMessage", "GateWay降级：服务异常");
        map.put("resultObj", "null");
        return map;
    }
}

