package com.example.dfreeman.bettertodolist;

import com.example.dfreeman.bettertodolist.model.DonsCalendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DonsCalendarTest {

    private DonsCalendar donsCalendar1;
    private DonsCalendar donsCalendar2;
    private DonsCalendar donsCalendar3;

    @Before
    public void setUp() throws Exception {
        donsCalendar1 = new DonsCalendar();
        donsCalendar2 = new DonsCalendar();
        donsCalendar3 = new DonsCalendar();
    }

    @Test
    public void set() throws Exception {
        donsCalendar1.set(2013, 2, 3);
        donsCalendar2.set(2014, 6, 12);
        donsCalendar3.set(2015, 7, 11);
        assertEquals("Mar 3 2013", donsCalendar1.toString());
        assertEquals("Jul 12 2014", donsCalendar2.toString());
        assertEquals("Aug 11 2015", donsCalendar3.toString());
    }

}