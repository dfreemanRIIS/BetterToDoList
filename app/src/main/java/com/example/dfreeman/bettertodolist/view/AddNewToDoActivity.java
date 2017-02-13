package com.example.dfreeman.bettertodolist.view;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dfreeman.bettertodolist.fragment.DatePickerFragment;
import com.example.dfreeman.bettertodolist.R;
import com.example.dfreeman.bettertodolist.fragment.TimePickerFragment;
import com.example.dfreeman.bettertodolist.model.ToDoItem;

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
            String startText = "Start date: " + newToDo.getStartCal().toString();
            start.setText(startText);
            TextView end = (TextView)findViewById(R.id.endDate);
            String endText = "End date: " + newToDo.getFinishCal().toString();
            end.setText(endText);
            TextView rem = (TextView)findViewById(R.id.reminder);
            String remText = "Reminder date: " + newToDo.getReminderCal().toString();
            rem.setText(remText);

            //Display Time
            TextView time = (TextView)findViewById(R.id.endTime);
            if (newToDo.getHour() == -1 && newToDo.getMin() == -1) {
                String noTime= "Time: No time selected!";
                time.setText(noTime);
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
            String startText = "Start date: No date selected!";
            start.setText(startText);
            TextView end = (TextView)findViewById(R.id.endDate);
            String endText = "End date: No date selected!";
            end.setText(endText);
            TextView rem = (TextView)findViewById(R.id.reminder);
            String remText = "Reminder date: No date selected!";
            rem.setText(remText);

            //Default Time
            TextView time = (TextView)findViewById(R.id.endTime);
            String noTime = "Time: No time selected!";
            time.setText(noTime);

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
