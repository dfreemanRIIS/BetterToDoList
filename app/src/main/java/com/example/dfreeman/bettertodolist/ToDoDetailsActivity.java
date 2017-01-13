package com.example.dfreeman.bettertodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
