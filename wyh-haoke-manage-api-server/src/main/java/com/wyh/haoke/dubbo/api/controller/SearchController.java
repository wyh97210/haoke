package com.wyh.haoke.dubbo.api.controller;

import com.wyh.haoke.dubbo.api.service.SearchService;
import com.wyh.haoke.dubbo.api.vo.es.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;
    @GetMapping
    public SearchResult search(@RequestParam("keyWord") String keyWord,
                               @RequestParam(value = "page", defaultValue = "1")
                                       Integer page) {
        if(page > 100){ //防止爬虫抓取过多的数据
            page = 1;
        }
        return this.searchService.search(keyWord, page);
    }


}
