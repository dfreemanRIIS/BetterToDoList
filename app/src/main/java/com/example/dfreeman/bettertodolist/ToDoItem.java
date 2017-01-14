package com.example.dfreeman.bettertodolist;

import java.text.SimpleDateFormat;

/**
 * Created by dfreeman
 */

public class ToDoItem {
    private String name;
    private DonsCalendar startCal;
    private DonsCalendar finishCal;
    private DonsCalendar reminderCal;
    private boolean complete;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

    //Getters
    public String getName() {
        return name;
    }
    public DonsCalendar getStartCal() {
        return startCal;
    }
    public DonsCalendar getFinishCal() {
        return finishCal;
    }
    public DonsCalendar getReminderCal() {
        return reminderCal;
    }
    public boolean isComplete() {
        return complete;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setStartCal(DonsCalendar startCal) {
        this.startCal = startCal;
    }
    public void setFinishCal(DonsCalendar finishCal) {
        this.finishCal = finishCal;
    }
    public void setReminderCal(DonsCalendar reminderCal) {
        this.reminderCal = reminderCal;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String toString() {
        return this.name;
    }
}
