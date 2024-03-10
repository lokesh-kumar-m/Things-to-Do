package com.dev.todoApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> createTodos=new ArrayList<>();
    static {
        createTodos.add(new Todo(1, "Jean", "get Milk", LocalDate.now().plusDays(3), "pending"));
        createTodos.add(new Todo(2, "Jean", "Pay Electricity", LocalDate.now().plusDays(6), "pending"));
    }

    public void addTodo(long itemId, String itemName,String itemDescription, long days, String itemStatus){
        createTodos.add(new Todo(itemId, itemName, itemDescription, LocalDate.now().plusDays(days), itemStatus));
    }

    public List<Todo> findByUserName(String userName){
        return createTodos;
    }
}
