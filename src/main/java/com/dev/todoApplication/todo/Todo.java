package com.dev.todoApplication.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//This entity is mapped to a table in database
//When we have a entity we also need a peimary key(@Id)
//As soon as spring sees Entity it creates table in h2
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private long id;
    private String userName;
//  @Size(min=10,message="Enter atleast 10 characters") validation    
    private String description;
    private LocalDate targetDate;
    private String status;

    public Todo( long id, String userName,String description, LocalDate targetDate, String status ){
       super();
       this.id=id;
       this.userName=userName;
       this.description=description;
       this.targetDate=targetDate;
       this.status=status;
    }
    public Todo(){

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return " "+id+" "+userName+" "+description+" "+targetDate+" "+status;
    }

}
