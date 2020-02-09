package com.tp.configclient.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: IndexController
 * Author:   TP
 * Date:     2020-02-09 12:56
 * Description:
 */
@RestController
@RefreshScope //必须添加此注解，否则配置中心变更后到客户端将无法刷新
public class IndexController {

    @Value("${springcloud.book.config:123}")
    private String book;

   @RequestMapping("/getBookConfig")
    public String getBookConfig(){
        return book;
    }
}
