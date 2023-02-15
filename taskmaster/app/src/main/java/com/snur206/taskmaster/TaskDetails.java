package com.snur206.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        Intent callingIntent = getIntent();
        String userTaskString = null;
        if(callingIntent != null) {
            userTaskString = callingIntent.getStringExtra(MainActivity.TASK_INPUT_EXTRA_TAG);
            TextView userTaskTextView = (TextView)findViewById(R.id.taskDetailPage);
            if(userTaskString != null) {
                userTaskTextView.setText(userTaskString);
            } else {
                userTaskTextView.setText("No input");
            }
        }

//        Button addTaskOneButton = (Button) findViewById(R.id.taskDetailsBtn);

    }
}