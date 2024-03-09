package com.dev.todoApplication.initializer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//When using Controller, we get error if we do not use ResponseBody
//Instead of Controller we can use RestController and omit ResponseBody
//@Controller
@RestController
public class InititlizingApplication {
    
    @RequestMapping("/hello")
//    @ResponseBody
    public String statirngApp(){
        return "<h1>Hello!</h1>";
    }
}
