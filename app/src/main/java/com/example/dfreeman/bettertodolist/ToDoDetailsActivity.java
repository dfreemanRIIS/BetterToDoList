package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class ToDoDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_TODONO = "toDoNumber";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_details);

        //Fetch object
        int toDoNo = (Integer)getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);

        //Display Name
        TextView name = (TextView)findViewById(R.id.displayName);
        name.setText(THIStoDoItem.getName());

        //Displays Calendars
        TextView start = (TextView)findViewById(R.id.showStartDate);
        start.setText("Start date: " + THIStoDoItem.getStartCal().toString());
        TextView end = (TextView)findViewById(R.id.showEndDate);
        end.setText("End date: " + THIStoDoItem.getFinishCal().toString());
        TextView rem = (TextView)findViewById(R.id.showRemDate);
        rem.setText("Reminder date: " + THIStoDoItem.getReminderCal().toString());

        //Display Time
        TextView time = (TextView)findViewById(R.id.time);
        if (THIStoDoItem.getHour() == -1 && THIStoDoItem.getMin() == -1) {
            time.setText("Time: No time selected!");
        } else {
            time.setText("Time: " + THIStoDoItem.getHour() + ":" + THIStoDoItem.getMin());
        }

        //Complete button setup
        Button markComp = (Button)findViewById(R.id.markComplete);
        if(THIStoDoItem.isComplete()) {
            markComp.setText("Mark Incomplete");
        } else {
            markComp.setText("Mark Complete");
        }
    }

    public void onMarkDelete(View v) {
        //Fetch object number and name
        int toDoNo = (Integer)getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);
        String THISname = THIStoDoItem.getName();

        //Delete it
        Toast.makeText(this, "DELETE " + THISname, Toast.LENGTH_SHORT).show();
        ToDoItem.itemList.remove(toDoNo);

        //Go back to menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCompButtonClick(View v) {
        //Fetch object number and name
        int toDoNo = (Integer)getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);
        String THISname = THIStoDoItem.getName();

        //Mark it complete or incomplete
        if(THIStoDoItem.isComplete()) {
            THIStoDoItem.setComplete(false);
            Toast.makeText(this, THISname + " is now incomplete", Toast.LENGTH_SHORT).show();

        } else {
            THIStoDoItem.setComplete(true);
            Toast.makeText(this, THISname + " is now complete", Toast.LENGTH_SHORT).show();
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
        int toDoNo = (Integer)getIntent().getExtras().get(EXTRA_TODONO);
        ToDoItem THIStoDoItem;
        THIStoDoItem = ToDoItem.itemList.get(toDoNo);

        //Delete old object
        ToDoItem.itemList.remove(toDoNo);

        //Pass new info into temp
        ToDoItem.editToDoTemp = THIStoDoItem;
        Intent intent = new Intent(this, AddNewToDoActivity.class);
        startActivity(intent);
    }
}
