package com.dev.todoApplication.todo;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class TodoControllerJpa {

    
    org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());

    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository){
        super();
        this.todoService=todoService;
        this.todoRepository=todoRepository;
    }
    private TodoService todoService;
    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value="/todo-list", method = RequestMethod.GET)
    public String getTodos(ModelMap model){
        String name=getName(model);
        logger.debug(name);
        List<Todo> list=todoRepository.findByUserName(name);
        model.put("Todos",list);
        return "todosList";
    }

    @RequestMapping(value = "/todo-list", method = RequestMethod.POST)
    public String addTodos( @RequestParam String itemName, @RequestParam String itemDescription, @RequestParam long days, ModelMap model){
        //logger.debug(itemDescription);
        //logger.debug(itemName);
        //logger.debug(""+days);
        todoService.addTodo( itemName, itemDescription, days);
        return "redirect:todo-list";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam long id){
        todoService.deleteTodo(id);
        return "redirect:todo-list";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.GET)
    public String updateTodoList(@RequestParam long id, ModelMap model){
        //logger.debug(""+id);
        model.put("id",id);
        return "updateList";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.POST)
    public String updateTodo(@RequestParam long id, @RequestParam String updateField,@RequestParam String updatedValue, ModelMap model){
        if(updateField.equals("Choose Field")|| updatedValue==""){
            model.put("Error","Enter valid fields to update");
            return "updateList";
        }
        todoService.updateTodo(id,updateField, updatedValue);
        return "redirect:todo-list";
    }

    public String getName(ModelMap model){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
   
}
