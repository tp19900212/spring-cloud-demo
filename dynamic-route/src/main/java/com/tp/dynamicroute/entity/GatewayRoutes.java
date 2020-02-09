package com.tp.dynamicroute.entity;

import com.alibaba.fastjson.JSON;
import com.tp.dynamicroute.dto.GatewayFilterDefinition;
import com.tp.dynamicroute.dto.GatewayPredicateDefinition;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Data
public class GatewayRoutes {
    private Long id;

    private String routeId;

    private String routeUri;

    private Integer routeOrder;

    private Boolean isEbl;

    private Boolean isDel;

    private Date createTime;

    private Date updateTime;

    private String predicates;

    private String filters;

    /**
     * 获取断言集合
     * @return
     */
    public List<GatewayPredicateDefinition> getPredicateDefinition(){
        if(!StringUtils.isEmpty(this.predicates)){
            return JSON.parseArray(this.predicates , GatewayPredicateDefinition.class);
        }
        return null;
    }

    /**
     * 获取过滤器集合
     * @return
     */
    public List<GatewayFilterDefinition> getFilterDefinition(){
        if(!StringUtils.isEmpty(this.filters)){
            return JSON.parseArray(this.filters , GatewayFilterDefinition.class);
        }
        return null;
    }


    @Override
    public String toString() {
        return "GatewayRoutes{" +
                "id=" + id +
                ", routeId='" + routeId + '\'' +
                ", routeUri='" + routeUri + '\'' +
                ", routeOrder=" + routeOrder +
                ", isEbl=" + isEbl +
                ", isDel=" + isDel +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", predicates='" + predicates + '\'' +
                ", filters='" + filters + '\'' +
                '}';
    }
}