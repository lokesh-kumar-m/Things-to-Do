package com.dev.todoApplication.todo;

import java.time.LocalDate;

public class Todo {
    private long id;
    private String userName;
    private String description;
    private LocalDate targetDate;
    private boolean status;

    public Todo( long id, String userName,String description, LocalDate targetDate, boolean status ){
       super();
       this.id=id;
       this.userName=userName;
       this.description=description;
       this.targetDate=targetDate;
       this.status=status;
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

    public boolean getSatus(){
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return " "+id+" "+userName+" "+description+" "+targetDate+" "+status;
    }

}
