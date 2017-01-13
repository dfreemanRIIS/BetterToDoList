package com.example.dfreeman.bettertodolist;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by dfreeman
 */

public class ToDoItem {
    private String name;
    private Calendar startCal;
    private Calendar finishCal;
    private Calendar reminderCal;
    private boolean complete;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

    //Getters
    public String getName() {
        return name;
    }
    public Calendar getStartCal() {
        return startCal;
    }
    public Calendar getFinishCal() {
        return finishCal;
    }
    public Calendar getReminderCal() {
        return reminderCal;
    }
    public boolean isComplete() {
        return complete;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setStartCal(Calendar startCal) {
        this.startCal = startCal;
    }
    public void setFinishCal(Calendar finishCal) {
        this.finishCal = finishCal;
    }
    public void setReminderCal(Calendar reminderCal) {
        this.reminderCal = reminderCal;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
