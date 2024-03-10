package com.dev.todoApplication.todo;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class TodoController {

    org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());

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
    public String updateTodos( @RequestParam String itemName, @RequestParam String itemDescription, @RequestParam long days, ModelMap model){
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
        model.put("id",id);
        return "updateList";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.POST)
    public String updateTodo(@RequestParam long id, @RequestParam String updateField,@RequestParam String updatedValue){
        logger.debug(updateField);
        if(updateField.equals("Choose Field")|| updatedValue==""){
            return "updateList";
        }
        todoService.updateTodo(id,updateField, updatedValue);
        return "redirect:todo-list";
    }
   
}
