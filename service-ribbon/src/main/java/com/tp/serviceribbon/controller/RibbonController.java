package com.tp.serviceribbon.controller;

import com.tp.serviceribbon.service.RibbonHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: RibbonController
 * Author:   TP
 * Date:     2019-10-27 18:02
 * Description:
 */
@RestController
public class RibbonController {

    @Autowired
    RibbonHiService ribbonHiService;

    @RequestMapping(value = "/ribbonHi")
    public String hi(@RequestParam(value = "name", defaultValue = "TP") String name) {
        try {
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ribbonHiService.hiService(name);
    }
}
