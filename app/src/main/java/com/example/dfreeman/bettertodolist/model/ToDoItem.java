package com.example.dfreeman.bettertodolist.model;

import com.example.dfreeman.bettertodolist.view.MainActivity;

import java.util.ArrayList;

public class ToDoItem {
    private String name;
    private DonsCalendar startCal;
    private DonsCalendar finishCal;
    private DonsCalendar reminderCal;
    private boolean complete;
    private int hour;
    private int min;

    //Array of toDoItems
    public static final ArrayList<ToDoItem> itemList = new ArrayList<>();
    //Stores temp obj for edit
    public static ToDoItem editToDoTemp = new ToDoItem();

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

    public void setStartCal() {
        this.startCal = MainActivity.tempStartCal;
    }

    public void setFinishCal() {
        this.finishCal = MainActivity.tempEndCal;
    }

    public void setReminderCal() {
        this.reminderCal = MainActivity.tempRemCal;
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
        if (complete) {
            return this.name + " [COMPLETE]";
        } else {
            return this.name;
        }
    }
}
