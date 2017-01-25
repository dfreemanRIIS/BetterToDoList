package com.example.dfreeman.bettertodolist;

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
        String monthString = "";
        if (month == 0) {
            monthString = "Jan";
        }
        if (month == 1) {
            monthString = "Feb";
        }
        if (month == 2) {
            monthString = "Mar";
        }
        if (month == 3) {
            monthString = "Apr";
        }
        if (month == 4) {
            monthString = "May";
        }
        if (month == 5) {
            monthString = "Jun";
        }
        if (month == 6) {
            monthString = "Jul";
        }
        if (month == 7) {
            monthString = "Aug";
        }
        if (month == 8) {
            monthString = "Sep";
        }
        if (month == 9) {
            monthString = "Oct";
        }
        if (month == 10) {
            monthString = "Nov";
        }
        if (month == 11) {
            monthString = "Dec";
        }

        if(year == 0 && month == 0 && day == 0) {
            return "No date selected!";
        }

        return monthString + " " + day + " " + year;
    }
}
