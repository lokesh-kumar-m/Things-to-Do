package com.dev.todoApplication.todo;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("userName")
public class TodoControllerJpa {

    
    org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());

    public TodoControllerJpa( TodoRepository todoRepository){
        super();
        this.todoRepository=todoRepository;
    }
    static int x=11;
    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value="/todo-list", method = RequestMethod.GET)
    public String getTodos(ModelMap model){
        String name=getName(model);
        //logger.debug(name);
        List<Todo> list=todoRepository.findByUserName(name);
        model.put("Todos",list);
        return "todosList";
    }

    @RequestMapping(value = "/todo-list", method = RequestMethod.POST)
    public String addTodos( @RequestParam String itemDescription, @RequestParam long days, ModelMap model){
        String name=getName(model);
        Todo todo=new Todo();
        todo.setId(x++);
        todo.setUserName(name);
        todo.setDescription(itemDescription);
        todo.setTargetDate(LocalDate.now().plusDays(days));
        todo.setStatus("pending");
        todoRepository.save(todo);
        return "redirect:todo-list";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam long id){
        todoRepository.deleteById((int)id);
        return "redirect:todo-list";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.GET)
    public String updateTodoList(@RequestParam long id, ModelMap model){
        //logger.debug(""+id);
        model.put("id",id);
        return "updateList";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.POST)
    public String updateTodo(@RequestParam int id, @RequestParam String updateField,@RequestParam String updatedValue, ModelMap model){
        if(updateField.equals("Choose Field")|| updatedValue==""){
            model.put("Error","Enter valid fields to update");
            return "updateList";
        }
        Todo todo=todoRepository.findById(id).get();
        if(updateField.equals("itemdescription")){
            todo.setDescription(updatedValue);
        }
        else if(updateField.equals("itemdays")){
            todo.setTargetDate(LocalDate.now().plusDays(Long.parseLong(updatedValue)));
        }
        else{
            todo.setStatus(updatedValue);
        }
        todoRepository.save(todo);
        return "redirect:todo-list";
    }

    public String getName(ModelMap model){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
   
}
