package com.tp.servicefeign.service.impl;

import com.tp.servicefeign.service.FeignHiService;
import org.springframework.stereotype.Component;

/**
 * FileName: FeignHiServiceHystrixImpl
 * Author:   TP
 * Date:     2019-10-12 13:07
 * Description:
 */
@Component
public class FeignHiServiceHystrixImpl implements FeignHiService {

    @Override
    public String sayHiByFeignCall(String name) {
        return "Sorry " + name + ", Server service-feign is unavailable....";
    }
}
