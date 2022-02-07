package com.example.aop.controller;

import com.example.aop.aop.cutpoint.AfterCutPoint;
import com.example.aop.aop.cutpoint.AfterReturnCutPoint;
import com.example.aop.aop.cutpoint.AroundCutPoint;
import com.example.aop.aop.cutpoint.BeforeCutPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/after")
    @AfterCutPoint
    public String after(@RequestParam String body){
        System.out.println("method process,body:"+body);
        return body;
    }
    @GetMapping("/before")
    @BeforeCutPoint
    public String before(@RequestParam String body){
        System.out.println("method process,body:"+body);
        return body;
    }
    @GetMapping("/around")
    @AroundCutPoint
    public String around(@RequestParam String body){
        System.out.println("method process,body:"+body);
        return body;
    }
    @GetMapping("/result")
    @AfterReturnCutPoint
    public String result(@RequestParam String body){
        System.out.println("method process,body:"+body);
        return body;
    }
}
