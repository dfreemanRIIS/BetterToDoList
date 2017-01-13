package com.example.dfreeman.bettertodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddNewToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_to_do);
    }

    public void onDoneCreating(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
