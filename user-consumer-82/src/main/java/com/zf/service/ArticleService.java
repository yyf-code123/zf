package com.zf.service;

import com.zf.entity.Article;
import com.zf.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EARLYSTAGE-PROVIDER-SERVICE")
@Service
public interface ArticleService {
    @GetMapping(value = "/article/get/{id}")
    public CommonResult<Article> getOne(@PathVariable("id") Integer id);


    @PostMapping(value = "/article/save")
    public CommonResult<Article> save(@RequestBody Article article);

    @PostMapping(value = "/article/update")
    public CommonResult<Article> update(@RequestBody Article article);

    @RequestMapping(value = "/article/delete/{id}")
    public CommonResult<Article> delete(@PathVariable("id") Integer id);

}