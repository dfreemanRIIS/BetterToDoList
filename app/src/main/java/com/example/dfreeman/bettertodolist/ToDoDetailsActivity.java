package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        THIStoDoItem = MainActivity.itemList.get(toDoNo);

        //Display Name
        TextView name = (TextView)findViewById(R.id.displayName);
        name.setText(THIStoDoItem.getName());
    }

    public void onMarkDelete(View v) {
        //Delete it

        //Go back to menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
