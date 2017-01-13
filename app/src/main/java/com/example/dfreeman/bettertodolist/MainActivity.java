package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ToDoItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listToDos = (ListView)findViewById(R.id.mainMenuList);
        ArrayAdapter<ToDoItem> listAdapter;
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listToDos.setAdapter(listAdapter);

    }

    public void onAddNewActivity(View view) {
        Intent intent = new Intent(this, AddNewToDoActivity.class);
        startActivity(intent);
    }
}
