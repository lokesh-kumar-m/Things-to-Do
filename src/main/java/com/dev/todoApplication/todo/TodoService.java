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
}
