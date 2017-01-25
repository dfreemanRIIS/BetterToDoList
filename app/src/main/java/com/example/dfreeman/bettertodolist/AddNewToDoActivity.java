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
        if(MainActivity.isEditing) {
            newToDo = ToDoItem.editToDoTemp;

            //Set name
            TextView name = (TextView)findViewById(R.id.enter_name);
            name.setText(newToDo.getName());

            //Displays Calendars
            TextView start = (TextView)findViewById(R.id.startDate);
            start.setText("Start date: " + newToDo.getStartCal().toString());
            TextView end = (TextView)findViewById(R.id.endDate);
            end.setText("End date: " + newToDo.getFinishCal().toString());
            TextView rem = (TextView)findViewById(R.id.reminder);
            rem.setText("Reminder date: " + newToDo.getReminderCal().toString());

            //Display Time
            TextView time = (TextView)findViewById(R.id.endTime);
            if (newToDo.getHour() == -1 && newToDo.getMin() == -1) {
                time.setText("Time: No time selected!");
            } else {
                time.setText("Time: " + newToDo.getHour() + ":" + newToDo.getMin());
            }

            //Reset the editing bool
            MainActivity.isEditing = false;
        } else {
            //Default to blank
            MainActivity.tempStartCal.set(0, 0, 0);
            MainActivity.tempEndCal.set(0, 0, 0);
            MainActivity.tempRemCal.set(0, 0, 0);
            MainActivity.hour = -1;
            MainActivity.minute = -1;

            //Default Calendars
            TextView start = (TextView)findViewById(R.id.startDate);
            start.setText("Start date: No date selected!");
            TextView end = (TextView)findViewById(R.id.endDate);
            end.setText("End date: No date selected!");
            TextView rem = (TextView)findViewById(R.id.reminder);
            rem.setText("Reminder date: No date selected!");

            //Default Time
            TextView time = (TextView)findViewById(R.id.endTime);
            time.setText("Time: No time selected!");

            //Reset the editing bool
            MainActivity.isEditing = false;
        }
    }

    public void onDoneCreating(View view) {
        //Set Name
        EditText newTaskName = (EditText)findViewById(R.id.enter_name);
        String newTaskNameString = newTaskName.getText().toString();
        newToDo.setName(newTaskNameString);

        //Set Start Cal
        newToDo.setStartCal();

        //Set Completion Cal
        newToDo.setFinishCal();

        //Set Reminder Cal
        newToDo.setReminderCal();

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
        DatePickerFragment.isStartCal=true;
        showDatePickerDialog(v);
    }
    public void showEndDatePickerDialog(View v) {
        DatePickerFragment.isEndCal=true;
        showDatePickerDialog(v);
    }
    public void showRemDatePickerDialog(View v) {
        DatePickerFragment.isRemCal=true;
        showDatePickerDialog(v);
    }

    private void showDatePickerDialog(View v) {
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
