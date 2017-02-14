package com.example.dfreeman.bettertodolist;

import com.example.dfreeman.bettertodolist.model.DonsCalendar;
import com.example.dfreeman.bettertodolist.model.ToDoItem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToDoItemTest {

    private ToDoItem toDoItem;

    @Before
    public void setUp() throws Exception {
        toDoItem = new ToDoItem();
    }

    @Test
    public void setName() throws Exception {
        toDoItem.setName("Test Name");
        String result = toDoItem.getName();
        assertEquals("Test Name", result);
    }

    @Test
    public void setStartCal() throws Exception {
        DonsCalendar donsCalendar = new DonsCalendar();
        donsCalendar.set(2010, 2, 2);
        assertEquals("Mar 2 2010", donsCalendar.toString());
    }

    @Test
    public void setFinishCal() throws Exception {
        DonsCalendar donsCalendar = new DonsCalendar();
        donsCalendar.set(2012, 3, 4);
        assertEquals("Apr 4 2012", donsCalendar.toString());
    }

    @Test
    public void setReminderCal() throws Exception {
        DonsCalendar donsCalendar = new DonsCalendar();
        donsCalendar.set(2015, 5, 1);
        assertEquals("Jun 1 2015", donsCalendar.toString());
    }

    @Test
    public void setComplete() throws Exception {
        toDoItem.setComplete(true);
        boolean result = toDoItem.isComplete();
        assertEquals(true, result);
    }

    @Test
    public void setHour() throws Exception {
        toDoItem.setHour(4);
        int result = toDoItem.getHour();
        assertEquals(4, result);
    }

    @Test
    public void setMin() throws Exception {
        toDoItem.setMin(30);
        int result = toDoItem.getMin();
        assertEquals(30, result);
    }

}