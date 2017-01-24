package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewToDoActivity extends AppCompatActivity {
    //Create new toDoItem
    private ToDoItem newToDo = new ToDoItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_to_do);

        //Check for existing obj from edit
        if(ToDoItem.editToDoTemp.getName() != "") {
            newToDo = ToDoItem.editToDoTemp;

            //Set name
            TextView name = (TextView)findViewById(R.id.enter_name);
            name.setText(newToDo.getName());
        } else {
            //Default to blank
            MainActivity.tempStartCal.set(0, 0, 0);
            MainActivity.tempEndCal.set(0, 0, 0);
            MainActivity.tempRemCal.set(0, 0, 0);
            MainActivity.hour = -1;
            MainActivity.minute = -1;
        }
    }

    public void onDoneCreating(View view) {
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

        //Add Time
        newToDo.setHour(MainActivity.hour);
        newToDo.setMin(MainActivity.minute);

        //Submit new toDoItem
        ToDoItem.itemList.add(newToDo);

        //Clear newToDo
        newToDo = new ToDoItem();
        //zero out temp edit
        ToDoItem.editToDoTemp = new ToDoItem();

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

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void onClearReminder(View v) {
        MainActivity.tempRemCal.set(0, 0, 0);
        Toast.makeText(this, "Reminder Cleared!", Toast.LENGTH_SHORT).show();
    }
}
