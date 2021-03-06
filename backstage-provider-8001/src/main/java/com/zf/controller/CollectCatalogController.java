package com.zf.controller;

import com.zf.entity.Classification;
import com.zf.entity.CollectCatalog;
import com.zf.entity.CommonResult;
import com.zf.service.ClassificationService;
import com.zf.service.CollectCatalogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 2021-01-13 11:29
 */
@RestController
@RequestMapping("/admin/collectCatalog")
public class CollectCatalogController {
    @Resource
    private CollectCatalogService collectCatalogService;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id){
        CollectCatalog result = collectCatalogService.findById(id);
        return new CommonResult(200,"查询成功",result);
    }

    @PostMapping("/save")
    public CommonResult save(@RequestBody CollectCatalog collectCatalog){
        CollectCatalog result = collectCatalogService.save(collectCatalog);
        if(null!=result) {
            return new CommonResult(200, "更新成功", result);
        }else{
            return new CommonResult(404,"更新失败");
        }
    }

    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Integer id){
        Integer result = collectCatalogService.delete(id);
        if (result>0) {
            return new CommonResult(200, "删除成功");
        }else{
            return new CommonResult(404, "删除失败");
        }
    }
}
