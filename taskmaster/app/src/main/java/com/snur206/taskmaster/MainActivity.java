package com.snur206.taskmaster;

import static com.snur206.taskmaster.UserSettingsActivity.USER_NAME_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    public final String TAG = "MainActivity";
    public static final String TASK_INPUT_EXTRA_TAG = "userTask";

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

            Button taskButtonOne = (Button)  findViewById(R.id.mainActivityTaskOneBtn);

            taskButtonOne.setOnClickListener(v -> {
                String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskOneBtn)).getText().toString();
                Intent goToTaskDetailFromIntent = new Intent(this, TaskDetails.class);
                goToTaskDetailFromIntent.putExtra(TASK_INPUT_EXTRA_TAG, taskDetail);
                startActivity(goToTaskDetailFromIntent);
            });

            Button taskButtonTwo = (Button)  findViewById(R.id.mainActivityTaskTwoBtn);

            taskButtonTwo.setOnClickListener(v -> {
                String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskTwoBtn)).getText().toString();
                Intent goToTaskDetailFromIntent = new Intent(this, TaskDetails.class);
                goToTaskDetailFromIntent.putExtra(TASK_INPUT_EXTRA_TAG, taskDetail);

                startActivity(goToTaskDetailFromIntent);
            });

            Button taskButtonThree = (Button)  findViewById(R.id.mainActivityTaskThreeBtn);

            taskButtonThree.setOnClickListener(v -> {
                String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskThreeBtn)).getText().toString();
                Intent goToTaskDetailFromIntent = new Intent(this, TaskDetails.class);
                goToTaskDetailFromIntent.putExtra(TASK_INPUT_EXTRA_TAG, taskDetail);

                startActivity(goToTaskDetailFromIntent);
            });


            ImageView settingsButton = (ImageView) findViewById(R.id.mainActivitySettingsImgView);
            settingsButton.setOnClickListener(v -> {
                String userInput = ((EditText)findViewById(R.id.mainActivityUserInputEditText)).getText().toString();
                Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
                goToUserSettingsIntent.putExtra(TASK_INPUT_EXTRA_TAG, userInput);
                startActivity(goToUserSettingsIntent);
            });


            // Step 1-2 Grab the RecylcerView
//            public void setUpRecyclerView = findViewById();
            // Step 1-3 Set the layout manager

        }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = preferences.getString(USER_NAME_TAG, "No Username");
        ((TextView)findViewById(R.id.mainActivityTaskMasterTextView)).setText(username);
    }
}