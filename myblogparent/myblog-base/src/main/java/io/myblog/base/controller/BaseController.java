package io.myblog.base.controller;

import entity.Result;
import entity.StatusCode;
import io.myblog.base.pojo.Label;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class BaseController {

    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功");
    }

    @GetMapping(value = "/{labelId}")
    public Result findById(@PathVariable("labelId") String labelId){
        return new Result(true,StatusCode.OK,"查询成功");

    }
    @PostMapping
    public Result save(@RequestBody Label label){
        return new Result(true,StatusCode.OK,"添加成功");
    }
    @PostMapping(value = "/{labelId}")
    public Result update(@PathVariable("labelId") String labelId,@RequestBody Label label){
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @PostMapping(value = "/{labelId}")
    public Result deleteById(@PathVariable("labelId") String labelId){
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
