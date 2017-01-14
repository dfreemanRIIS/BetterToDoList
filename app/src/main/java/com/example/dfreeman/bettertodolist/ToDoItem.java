package com.example.dfreeman.bettertodolist;

/**
 * Created by dfreeman
 */

public class ToDoItem {
    private String name;
    private DonsCalendar startCal;
    private DonsCalendar finishCal;
    private DonsCalendar reminderCal;
    private boolean complete;
    private int hour;
    private int min;

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
    public int getHour() {
        return hour;
    }
    public int getMin() {
        return min;
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
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMin(int min) {
        this.min = min;
    }

    public String toString() {
        return this.name;
    }
}
