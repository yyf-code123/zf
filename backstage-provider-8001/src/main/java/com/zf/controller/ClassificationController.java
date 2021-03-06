package com.zf.controller;

import com.zf.entity.Article;
import com.zf.entity.Classification;
import com.zf.entity.CommonResult;
import com.zf.service.ArticleService;
import com.zf.service.ClassificationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * 2021-01-13 11:29
 */

@RestController
@RequestMapping("/admin/classification")
public class ClassificationController {

    @Resource
    private ClassificationService classificationService;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id){
        Classification result = classificationService.findById(id);
        return new CommonResult(200,"查询成功",result);
    }

    @PostMapping("/save")
    public CommonResult save(@RequestBody Classification classification){
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance();
        String dateTime = df.format(date);
        classification.setBuiltTime(dateTime);
        Classification result = classificationService.save(classification);
        if(null!=result) {
            return new CommonResult(200, "更新成功", result);
        }else{
            return new CommonResult(404,"更新失败");
        }
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody Classification classification){
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance();
        String dateTime = df.format(date);
        classification.setBuiltTime(dateTime);
        Classification result = classificationService.save(classification);
        if(null!=result) {
            return new CommonResult(200, "更新成功", result);
        }else{
            return new CommonResult(404,"更新失败");
        }
    }



    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Integer id){
        Integer result = classificationService.delete(id);
        if (result>0) {
            return new CommonResult(200, "删除成功");
        }else{
            return new CommonResult(404, "删除失败");
        }
    }


}
