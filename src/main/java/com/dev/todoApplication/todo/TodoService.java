package com.dev.todoApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> createTodos=new ArrayList<>();
    private static int itemId=0;
    static {
        createTodos.add(new Todo(++itemId, "Jean", "get Milk", LocalDate.now().plusDays(3), "pending"));
    }

    public void addTodo( String itemName,String itemDescription, long days){
        createTodos.add(new Todo(++itemId, itemName, itemDescription, LocalDate.now().plusDays(days), "pending"));
    }

    public List<Todo> findByUserName(String userName){
        return createTodos;
    }

    public List<Todo> deleteTodo(Long id){
        for(int i=0;i<createTodos.size();i++){
            if(createTodos.get(i).getId()==id){
                createTodos.remove(i);
            }
        }
        return createTodos;
    }

    public List<Todo> updateTodo(Long id, String field, String value){
        for(int i=0;i<createTodos.size();i++){
            if(createTodos.get(i).getId()==id){
                if(field.equals("itemid")){
                    createTodos.get(i).setId(Long.parseLong(value));  
                }
                else if(field.equals("itemname")){
                    createTodos.get(i).setUserName(value);
                }
                else if(field.equals("itemdescription")){
                    createTodos.get(i).setDescription(value);
                }
                else if(field.equals("itemdays")){
                    createTodos.get(i).setTargetDate(LocalDate.now().plusDays(Long.parseLong(value)));
                }
                else{
                    createTodos.get(i).setStatus(value);
                }
            }
        }
        return createTodos;
    }
}
