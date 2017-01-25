package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Boolean for is edit
    public static boolean isEditing;

    //Store calendars until ToDoItem is created
    public static final DonsCalendar tempStartCal= new DonsCalendar(0,0,0);
    public static final DonsCalendar tempEndCal = new DonsCalendar(0,0,0);
    public static final DonsCalendar tempRemCal = new DonsCalendar(0,0,0);
    public static int hour = -1;
    public static int minute = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listToDos = (ListView) findViewById(R.id.mainMenuList);
        ArrayAdapter<ToDoItem> listAdapter;
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ToDoItem.itemList);
        listToDos.setAdapter(listAdapter);


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ToDoDetailsActivity.class);
                intent.putExtra(ToDoDetailsActivity.EXTRA_TODONO, (int) id);
                startActivity(intent);
            }
        };
        listToDos.setOnItemClickListener(itemClickListener);
    }

    public void onAddNewActivity(View view) {
        Intent intent = new Intent(this, AddNewToDoActivity.class);
        startActivity(intent);
    }
}
