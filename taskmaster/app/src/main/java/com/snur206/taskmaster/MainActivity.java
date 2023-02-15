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
                Intent goToTaskOneFromIntent = new Intent(this, TaskDetails.class);
                startActivity(goToTaskOneFromIntent);
            });

            Button taskButtonTwo = (Button)  findViewById(R.id.mainActivityTaskTwoBtn);

            taskButtonTwo.setOnClickListener(v -> {
                Intent goToTaskTwoFromIntent = new Intent(this, TaskDetails.class);
                startActivity(goToTaskTwoFromIntent);
            });

            Button taskButtonThree = (Button)  findViewById(R.id.mainActivityTaskThreeBtn);

            taskButtonThree.setOnClickListener(v -> {
                Intent goToTaskThreeFromIntent = new Intent(this, TaskDetails.class);
                startActivity(goToTaskThreeFromIntent);
            });


            ImageView settingsButton = (ImageView) findViewById(R.id.mainActivitySettingsImgView);
            settingsButton.setOnClickListener(v -> {
                String userInput = ((EditText)findViewById(R.id.mainActivityUserInputEditText)).getText().toString();
                Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
                goToUserSettingsIntent.putExtra(TASK_INPUT_EXTRA_TAG, userInput);
                startActivity(goToUserSettingsIntent);
            });


        }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = preferences.getString(USER_NAME_TAG, "No Username");
        ((TextView)findViewById(R.id.mainActivityTaskMasterTextView)).setText(username);
    }
}