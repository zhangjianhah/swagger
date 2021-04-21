package com.zj.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @ApiIgnore 隐藏api接口
 */
@RestController(value = "/demo")
@ApiIgnore
public class DemoController {

    @GetMapping("/test")
    public String test(){
        return "111";
    }



}
