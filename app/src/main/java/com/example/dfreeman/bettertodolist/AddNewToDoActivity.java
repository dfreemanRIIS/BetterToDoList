package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_to_do);

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

        //Submit new toDoItem
        MainActivity.itemList.add(newToDo);

        //Go back to menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
