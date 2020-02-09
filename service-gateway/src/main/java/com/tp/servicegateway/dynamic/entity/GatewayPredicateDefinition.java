package com.tp.servicegateway.dynamic.entity;


import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FileName: GatewayPredicateDefinition
 * Author:   TP
 * Date:     2020-02-08 17:03
 * Description:网关断言模型
 */
@Data
public class GatewayPredicateDefinition {

    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();
}
