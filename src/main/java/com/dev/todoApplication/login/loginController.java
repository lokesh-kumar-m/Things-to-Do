package com.dev.todoApplication.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
//SessionAttributes store the name variable in the session scope and persists across multiple requests. 
//The SessionAttribute(name) should be used in the place where we need the attribute name, look TodoController
@SessionAttributes("name")
public class loginController {
    
    private Authentication authentication;

    public loginController(Authentication authentication){
        super();
        this.authentication=authentication;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String welcome(@RequestParam String name,@RequestParam String password,ModelMap model){
        model.put("name",name);
        model.put("password",password);
        if(authentication.authorize(name, password)){
            return "welcome";
        }
        model.put("ErrorMessage","Invalid Username/Password");
        return "login";   
    }
}
