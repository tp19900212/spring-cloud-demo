package com.tp.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: HiController
 * Author:   TP
 * Date:     2019-10-12 11:43
 * Description:
 */
@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "TP") String name) {
        // try {
        //     Thread.sleep(4000);
        // }catch (Exception e){
        //     e.printStackTrace();
        // }
        return "Hi " + name + ", This is service-hi, I am from port:" + port;
    }

}
