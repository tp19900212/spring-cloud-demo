package com.tp.servicefeign.service.impl;

import com.tp.servicefeign.service.SearchGithubService;
import org.springframework.stereotype.Component;

/**
 * FileName: SearchGithubServiceImpl
 * Author:   TP
 * Date:     2020-02-06 19:42
 * Description:
 */
@Component
public class SearchGithubServiceImpl implements SearchGithubService {

    @Override
    public String searchGithub(String q) {
        return "Sorry, Server service-feign is unavailable....";
    }
}
