package com.example.time_pattern.Models;

import java.util.HashMap;

public class TimePattern {
    protected HashMap<Integer, String> pattern = new HashMap<Integer, String>();

    public TimePattern(HashMap<Integer, String> pattern) {
        this.pattern = pattern;
    }

    public HashMap<Integer, String> getPattern() {
        return pattern;
    }

    public void setPattern(HashMap<Integer, String> pattern) {
        this.pattern = pattern;
    }

    public void addToPattern(Integer Integer, String toDo){
        this.pattern.put(Integer,toDo);
    }
}
