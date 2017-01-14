package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_to_do);

        //In case the user does not enter any dates, set some defaults
        MainActivity.tempStartCal.set(0,0,0);
        MainActivity.tempEndCal.set(0,0,0);
        MainActivity.tempRemCal.set(0,0,0);

        //Will need to delete old to do eventually ***
        //Edit changes will bring you here, delete old one ***
        //New one will be added
    }

    public void onDoneCreating(View view) {
        //Create new toDoItem
        ToDoItem newToDo = new ToDoItem();

        //Set Name
        EditText newTaskName = (EditText)findViewById(R.id.enter_name);
        String newTaskNameString = newTaskName.getText().toString();
        newToDo.setName(newTaskNameString);

        //Set Start Cal
        newToDo.setStartCal(MainActivity.tempStartCal);

        //Set Completion Cal
        newToDo.setFinishCal(MainActivity.tempEndCal);

        //Set Reminder Cal
        newToDo.setReminderCal(MainActivity.tempRemCal);

        //Set not Complete
        newToDo.setComplete(false);

        //Submit new toDoItem
        MainActivity.itemList.add(newToDo);

        //Go back to menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //So DatePicker only sets the right calendar
    public void showStartDatePickerDialog(View v) {
        MainActivity.isStartCal=true;
        showDatePickerDialog(v);
    }
    public void showEndDatePickerDialog(View v) {
        MainActivity.isEndCal=true;
        showDatePickerDialog(v);
    }
    public void showRemDatePickerDialog(View v) {
        MainActivity.isRemCal=true;
        showDatePickerDialog(v);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
