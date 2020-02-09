package com.tp.servicefeign.service;

import com.tp.servicefeign.service.impl.SearchGithubServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FileName: FeignHiService2
 * Author:   TP
 * Date:     2020-02-06 19:26
 * Description:
 * 示例：@FeignClient注解指定了url就会访问该url地址，否则会把name参数当作服务名到注册中心中查询该名字服务，此时指定了url后可以随意命名
 */
@FeignClient(name = "search-github", url = "https://api.github.com", fallback = SearchGithubServiceImpl.class)
public interface SearchGithubService {

    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchGithub(@RequestParam("q")String query);
}
