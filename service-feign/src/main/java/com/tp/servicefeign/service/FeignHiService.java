package com.tp.servicefeign.service;

import com.tp.servicefeign.service.impl.FeignHiServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FileName: FeignHiService
 * Author:   TP
 * Date:     2019-10-12 12:51
 * Description:
 */
@FeignClient(value = "service-hi", fallback = FeignHiServiceHystrixImpl.class)
public interface FeignHiService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiByFeignCall(@RequestParam(value = "name") String name);
}
