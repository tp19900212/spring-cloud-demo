package com.tp.servicegateway.dynamic.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FileName: GatewayFilterDefinition
 * Author:   TP
 * Date:     2020-02-08 17:03
 * Description:网关过滤器模型
 */
@Data
public class GatewayFilterDefinition {

    //Filter Name
    private String name;
    //对应的路由规则
    private Map<String, String> args = new LinkedHashMap<>();
}
