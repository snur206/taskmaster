package com.snur206.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "MainActivity";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Add Event Listener for clicking a button
            // TODO: Step 1: Get a UI element by ID
            Button addTaskButton = (Button) findViewById(R.id.mainActivityAddTaskBtn);

            addTaskButton.setOnClickListener(v -> {
                Intent goToAddTaskFromIntent = new Intent(this, AddTaskActivity.class);
                startActivity(goToAddTaskFromIntent);
            });


            Button allTaskButton = (Button)  findViewById(R.id.mainActivityAllTaskBtn);

            allTaskButton.setOnClickListener(v -> {
                Intent goToAllTaskFromIntent = new Intent(this, AllTaskActivity.class);
                startActivity(goToAllTaskFromIntent);
            });


        }
}