package io.myblog.qa.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import io.myblog.qa.pojo.Problem;
import io.myblog.qa.service.ProblemService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;

	/**
	 * 最新回答问题列表
	 * @param labelid
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/newlist")
	public Result newlist(@RequestParam("labelid") String labelid,
						  @RequestParam("page") int page,
						  @RequestParam("rows") int rows){
		Page<Problem> pageData = problemService.newlist(labelid,page,rows);
		return new Result(true,StatusCode.OK,"查询成功",
				new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));

	}

	/**
	 * 热门回答问题列表
	 * @param labelid
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/hotlist")
	public Result hotlist(@RequestParam("labelid") String labelid,
						  @RequestParam("page") int page,
						  @RequestParam("rows") int rows){
		Page<Problem> pageData = problemService.hotlist(labelid,page,rows);
		return new Result(true,StatusCode.OK,"查询成功",
				new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
	}

	/**
	 * 等待回答问题列表
	 * @param labelid
	 * @param page
	 * @param rows
	 * @return
	 */
	@GetMapping("/waitlist")
	public Result waitlist(@RequestParam("labelid") String labelid,
						  @RequestParam("page") int page,
						  @RequestParam("rows") int rows){
		Page<Problem> pageData = problemService.waitlist(labelid,page,rows);
		return new Result(true,StatusCode.OK,"查询成功",
				new PageResult<Problem>(pageData.getTotalElements(),pageData.getContent()));
	}

	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",problemService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",problemService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",problemService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param problem
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Problem problem  ){
		problemService.add(problem);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param problem
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Problem problem, @PathVariable String id ){
		problem.setId(id);
		problemService.update(problem);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		problemService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
