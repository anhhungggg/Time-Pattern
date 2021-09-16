package com.example.time_pattern.Models;

public class TodoList {
    public String listName;
    protected int productivity;
    protected TimePattern timePattern;

    public TodoList(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public TimePattern getTimePattern() {
        return timePattern;
    }

    public void setTimePattern(TimePattern timePattern) {
        this.timePattern = timePattern;
    }
}
