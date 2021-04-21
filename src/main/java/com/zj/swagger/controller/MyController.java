package com.zj.swagger.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/my")
@Api(tags = {"用来演示Swagger的一些注解","222222222222"})
public class MyController {

    @GetMapping("/test11")
    public String test(){
        return "111";
    }
}
