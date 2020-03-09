package com.yy.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyy
 * @date 2020/3/9 22:41
 */
@RestController
@Api(value = "/testController", description = "测试控制类")
public class TestController {

    @GetMapping("/hello")
    @ApiOperation("测试")
    public String hello(){
        return "hello";
    }
}
