package com.example.dfreeman.bettertodolist.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dfreeman.bettertodolist.R;
import com.example.dfreeman.bettertodolist.model.ToDoItem;

public class ToDoDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_TODONO = "toDoNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_details);

        //Fetch object
        int toDoNo = (Integer) getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);

        //Display Name
        TextView name = (TextView) findViewById(R.id.displayName);
        name.setText(THIStoDoItem.getName());

        //Displays Calendars
        TextView start = (TextView) findViewById(R.id.showStartDate);
        String startText = "Start date: " + THIStoDoItem.getStartCal().toString();
        start.setText(startText);
        TextView end = (TextView) findViewById(R.id.showEndDate);
        String endText = "End date: " + THIStoDoItem.getFinishCal().toString();
        end.setText(endText);
        TextView rem = (TextView) findViewById(R.id.showRemDate);
        String remText = "Reminder date: " + THIStoDoItem.getReminderCal().toString();
        rem.setText(remText);

        //Display Time
        TextView time = (TextView) findViewById(R.id.time);
        if (THIStoDoItem.getHour() == -1 && THIStoDoItem.getMin() == -1) {
            String setTimeText = "Time: No time selected!";
            time.setText(setTimeText);
        } else {
            time.setText("Time: " + THIStoDoItem.getHour() + ":" + THIStoDoItem.getMin());
        }

        //Complete button setup
        Button markComp = (Button) findViewById(R.id.markComplete);
        if (THIStoDoItem.isComplete()) {
            String markText = "Mark Incomplete";
            markComp.setText(markText);
        } else {
            String markText = "Mark Complete";
            markComp.setText(markText);
        }
    }

    public void onMarkDelete(View v) {
        //Fetch object number and name
        int toDoNo = (Integer) getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);
        String thisName = THIStoDoItem.getName();

        //Delete it
        Toast.makeText(this, "DELETE " + thisName, Toast.LENGTH_SHORT).show();
        ToDoItem.itemList.remove(toDoNo);

        //Go back to menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCompButtonClick(View v) {
        //Fetch object number and name
        int toDoNo = (Integer) getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);
        String thisName = THIStoDoItem.getName();

        //Mark it complete or incomplete
        if (THIStoDoItem.isComplete()) {
            THIStoDoItem.setComplete(false);
            Toast.makeText(this, thisName + " is now incomplete", Toast.LENGTH_SHORT).show();

        } else {
            THIStoDoItem.setComplete(true);
            Toast.makeText(this, thisName + " is now complete", Toast.LENGTH_SHORT).show();
        }

        //Delete it and add it with new complete state
        ToDoItem.itemList.remove(toDoNo);
        ToDoItem.itemList.add(THIStoDoItem);

        //Go back to menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onEdit(View v) {
        //Fetch object
        int toDoNo = (Integer) getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);

        //Delete old object
        ToDoItem.itemList.remove(toDoNo);

        //Let the form know his is an edit
        MainActivity.isEditing = true;

        //Pass new info into temp
        ToDoItem.editToDoTemp = THIStoDoItem;
        Intent intent = new Intent(this, AddNewToDoActivity.class);
        startActivity(intent);
    }
}
