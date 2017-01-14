package com.example.dfreeman.bettertodolist;

/**
 * Created by dfreeman
 */

public class DonsCalendar {
    private int year;
    private int month;
    private int day;

    public DonsCalendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //All Setter
    public void set(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //Getters and Setters
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        return year + " " + month + " " + day;
    }
}
