package com.tp.servicefeign.controller;

import com.tp.servicefeign.service.FeignHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: FeignController
 * Author:   TP
 * Date:     2019-10-12 12:55
 * Description:
 */
@RestController
public class FeignHiController {

    // 编译器若报错，可无视
    // 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错
    @Autowired
    FeignHiService feignHiService;

    @RequestMapping(value = "/feignHi")
    public String sayHi(@RequestParam(value = "name", defaultValue = "TP") String name) {
        // try {
        //     Thread.sleep(4000);
        // }catch (Exception e){
        //     e.printStackTrace();
        // }
        return feignHiService.sayHiByFeignCall(name);
    }
}
