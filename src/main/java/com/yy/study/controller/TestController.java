package com.yy.study.controller;

import com.yy.study.bean.AuditBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        long a = 200;
        return "hello";
    }

    @PostMapping("/qq")
    public String testParam(@RequestBody  @Valid AuditBean bean, Errors errors){
        if (errors.hasErrors()) {
            FieldError error = (FieldError) errors.getAllErrors().get(0);
            return error.getField() + error.getDefaultMessage();
        }
        return "success";
    }

    public static void main(String[] args) {
       /* String s1 = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——_+|{}【】‘；：”“’。，、？]";
        String s3 = "[_]+";
        String data = "_";
        Pattern p = Pattern.compile(s1);
        Matcher m = p.matcher("www*");
        boolean b = m.find();
        System.out.println(m.find());*/

        double number1 = 1;
        double number2 = 20.2;
        double number3 = 300.03;
        double v4 = number1 + number2 + number3;
        double v = (number1 + number2 + number3) * 100;
        int v1 = (int) v;
        System.out.println(v4);
        System.out.println(v);
        System.out.println(v1);


        int n1 = 1;
        int n2 = 20;
        int n3 = (int) 29.3d;
        double v2 = (double) n1 + n2;
        float v3 = (float) n1 + n2;
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(n3);

    }
}
