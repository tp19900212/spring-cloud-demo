package com.tp.servicefeign.controller;

import com.tp.servicefeign.service.SearchGithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: SearchGithubController
 * Author:   TP
 * Date:     2020-02-06 19:44
 * Description:
 */

@RestController
public class SearchGithubController {

    @Autowired
    private SearchGithubService searchGithubService;

    @GetMapping("/searchGit")
    public String searchGithub(){
        return searchGithubService.searchGithub("spring-cloud");
    }
}
