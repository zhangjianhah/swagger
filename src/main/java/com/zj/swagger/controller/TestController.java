package com.zj.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * tags，标签，可以有多个，这样可以使得这个类有多个分组,因此多个类可以被分到同一个分组
 */
@RestController
@RequestMapping("/test")
@Api(tags = {"用来演示Swagger的一些注解","222222222222"})
public class TestController {

    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    @GetMapping("/updatePassword")
    public String updatePassword(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password,
                                 @RequestParam(value="newPassword") String newPassword){
        if(userId <= 0 || userId > 2){
            return "未知的用户";
        }
        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
            return "密码不能为空";
        }
        if(password.equals(newPassword)){
            return "新旧密码不能相同";
        }
        return "密码修改成功!";
    }

    @ApiOperation(value="测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "key", value = "关键值", required = true, dataType = "String")
    })
    @PostMapping(value = "/test")
    public String test(@RequestParam(value="key") String key, HttpServletRequest request){
        return "111";
    }


    @ApiOperation(value="测试表单", notes="测试表单")
    @PostMapping("/test1")
    public String test1(@RequestBody Map map){
        return "111";
    }
}
