package com.dev.todoApplication.welcome;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
//SessionAttributes store the name variable in the session scope and persists across multiple requests. 
//The SessionAttribute(name) should be used in the place where we need the attribute name, look TodoController
@SessionAttributes("name")
public class welcomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getLogin(){
        return "welcome";
    }
}
