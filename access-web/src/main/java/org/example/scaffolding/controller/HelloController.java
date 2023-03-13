package org.example.scaffolding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Leonardo
 * @CreatTime 2023/3/12 21:35
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("echo/{content}")
    public String echo(@PathVariable String content){
        return content;
    }

}
