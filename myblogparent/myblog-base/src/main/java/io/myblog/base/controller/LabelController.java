package io.myblog.base.controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.myblog.base.pojo.Label;
import io.myblog.base.service.LabelService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/findAll")
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    @GetMapping("/findById")
    public Result findById(@RequestParam String labelId){
        int i = 1/0;
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(labelId));
    }
    @PostMapping("/save")
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @PostMapping("/update")
    public Result update(@RequestParam String labelId ,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @PostMapping("/deleteById")
    public Result deleteById(@RequestParam String labelId ){
        labelService.deleteById(labelId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

   @GetMapping("/findSearch")
    public Result findSearch(@RequestBody Label label){
        List<Label> list = labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
   }

    @GetMapping("/pageQuery")
    public Result pageQuery(@RequestBody Label label,@RequestParam int page,@RequestParam int size){
        Page<Label> pageData = labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }


}
