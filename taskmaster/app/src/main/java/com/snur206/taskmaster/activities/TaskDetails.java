package com.snur206.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.snur206.taskmaster.R;
import com.snur206.taskmaster.activities.MainActivity;
import com.snur206.taskmaster.adapter.TaskRecyclerViewAdapter;

public class TaskDetails extends AppCompatActivity {
    Context callingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        consumeExtras();
//        Intent callingIntent = getIntent();
//        String userTaskString = null;
//        if(callingIntent != null) {
//            userTaskString = callingIntent.getStringExtra(MainActivity.TASK_INPUT_EXTRA_TAG);
//            TextView userTaskTextView = (TextView)findViewById(R.id.taskDetailPage);
//            if(userTaskString != null) {
//                userTaskTextView.setText(userTaskString);
//            } else {
//                userTaskTextView.setText("No input");
//            }
//        }

//        Button addTaskOneButton = (Button) findViewById(R.id.taskDetailsBtn);

    }

    public void consumeExtras(){
        Intent callingIntent = getIntent();
        String taskTitle = null;
        String taskBody = null;
        if (callingIntent != null) {
            taskTitle = callingIntent.getStringExtra(TaskRecyclerViewAdapter.TASK_TITLE_TAG);
            taskBody = callingIntent.getStringExtra(TaskRecyclerViewAdapter.TASK_BODY_TAG);
        }
        ((TextView) findViewById(R.id.TaskDetailsTVTitle)).setText(taskTitle);
        ((TextView) findViewById(R.id.TaskDetailsTVBody)).setText(taskBody);
    }
}