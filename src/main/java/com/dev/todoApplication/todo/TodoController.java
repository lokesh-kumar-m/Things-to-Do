package com.dev.todoApplication.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
    
    private TodoService todoService;
    public TodoController(TodoService todoService){
        super();
        this.todoService=todoService;
    }

    @RequestMapping(value="/todo-list", method = RequestMethod.GET)
    public String getTodos(ModelMap model){
        List<Todo> list=todoService.findByUserName(" ");
        model.put("Todos",list);
        return "todosList";
    }

    @RequestMapping(value = "/todo-list", method = RequestMethod.POST)
    public String updateTodos(@RequestParam long itemId, @RequestParam String itemName, @RequestParam String itemDescription, @RequestParam long days, @RequestParam String itemStatus, ModelMap model){
        todoService.addTodo(itemId, itemName, itemDescription, days, itemStatus);
        List<Todo> list=todoService.findByUserName(" ");
        model.put("Todos",list);
        return "todosList";
    }
   
}
