package com.dev.todoApplication.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
    
    private TodoService todoService;
    public TodoController(TodoService todoService){
        super();
        this.todoService=todoService;
    }

    @RequestMapping(value="/todo-list")
    public String getTodos(ModelMap model){
        List<Todo> list=todoService.findByUserName(" ");
        model.put("Todos",list);
        return "todosList";
    }
}
