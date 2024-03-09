package com.dev.todoApplication.login;

import org.springframework.stereotype.Service;

@Service
public class Authentication {
    
    public boolean authorize(String uname, String password){
        boolean isValidName = uname.equalsIgnoreCase("Lokesh");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");
        return (isValidName&&isValidPassword);
    }
}
