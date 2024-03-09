package com.dev.todoApplication.initializer;

//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

//Controller is used to define classes responsible for handling web request
//When using Controller, we get error if we do not use ResponseBody
//Instead of Controller we can use RestController and omit ResponseBody
@Controller
//@RestController == Controller + ResponseBody
//RestController is specifically used for Restful Apis
public class InititlizingApplication {

    //used for logging
    //private org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());
    //logger.debug("This logs at debug");

    @RequestMapping("/hello")
    @ResponseBody
    public String statirngApp(){
        return "<h1>Hello!</h1>";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String htmlString(){
        //Using string to write html code becomes teadious process hence we use views
        //Most popular views are JSP
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title>learning</title>");
        stringBuffer.append("</head>");
        stringBuffer.append("<body>");
        stringBuffer.append("<h1> This is Html document</h1>");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }

    // /src/main/resources/META-INF/resources/WEB-INF/jsp/initApp.jsp
    @RequestMapping("/jsp")
    public String getJsp(){
        return "hello";
    }
}
