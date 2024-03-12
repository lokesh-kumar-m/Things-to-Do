package com.dev.todoApplication.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
//SessionAttributes store the name variable in the session scope and persists across multiple requests. 
//The SessionAttribute(name) should be used in the place where we need the attribute name, look TodoController
public class welcomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getLogin(ModelMap model){
        model.put("username", getUName());
        return "welcome";
    }

    private String getUName(){
// In the securityContextHolder class, the get context holds getAuthentication method which hold the current loggen in user
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    
}
