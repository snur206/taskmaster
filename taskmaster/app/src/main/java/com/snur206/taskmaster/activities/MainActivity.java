package com.snur206.taskmaster.activities;

import static com.snur206.taskmaster.activities.UserSettingsActivity.USER_NAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.snur206.taskmaster.R;
import com.snur206.taskmaster.adapter.TaskRecyclerViewAdapter;
import com.snur206.taskmaster.database.TaskMasterDatabase;
import com.snur206.taskmaster.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TaskMasterDatabase taskMasterDatabase;
    public static final String DATABASE_TITLE = "task_title";
    List<TaskModel> taskModelsList = new ArrayList<>();
    TaskRecyclerViewAdapter adapter;

    //    public final String TAG = "MainActivity";
    public static final String TASK_INPUT_EXTRA_TAG = "userTask";

    //  TODO: Step 1-1: Add a RecyclerView in the WSYIWYG editor
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setUpRecyclerView();

            // Builder pattern
            taskMasterDatabase = Room.databaseBuilder(
                    getApplicationContext(),
                    TaskMasterDatabase.class,
                    DATABASE_TITLE)
                    .fallbackToDestructiveMigration() // If Room gets confused, it tosses your database; don't use this in production!
                    .allowMainThreadQueries()
                    .build();
            taskModelsList = taskMasterDatabase.taskDao().findAll();

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

//            Button taskButtonOne = (Button)  findViewById(R.id.mainActivityTaskOneBtn);
//
//            taskButtonOne.setOnClickListener(v -> {
//                String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskOneBtn)).getText().toString();
//                Intent goToTaskDetailFromIntent = new Intent(this, TaskDetails.class);
//                goToTaskDetailFromIntent.putExtra(TASK_INPUT_EXTRA_TAG, taskDetail);
//                startActivity(goToTaskDetailFromIntent);
//            });

//            Button taskButtonTwo = (Button)  findViewById(R.id.mainActivityTaskTwoBtn);
//
//            taskButtonTwo.setOnClickListener(v -> {
//                String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskTwoBtn)).getText().toString();
//                Intent goToTaskDetailFromIntent = new Intent(this, TaskDetails.class);
//                goToTaskDetailFromIntent.putExtra(TASK_INPUT_EXTRA_TAG, taskDetail);
//
//                startActivity(goToTaskDetailFromIntent);
//            });

//            Button taskButtonThree = (Button)  findViewById(R.id.mainActivityTaskThreeBtn);
//
//            taskButtonThree.setOnClickListener(v -> {
//                String taskDetail = ((TextView) findViewById(R.id.mainActivityTaskThreeBtn)).getText().toString();
//                Intent goToTaskDetailFromIntent = new Intent(this, TaskDetails.class);
//                goToTaskDetailFromIntent.putExtra(TASK_INPUT_EXTRA_TAG, taskDetail);
//
//                startActivity(goToTaskDetailFromIntent);
//            });


            ImageView settingsButton = (ImageView) findViewById(R.id.mainActivitySettingsImgView);
            settingsButton.setOnClickListener(v -> {
                String userInput = ((EditText)findViewById(R.id.mainActivityUserInputEditText)).getText().toString();
                Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
                goToUserSettingsIntent.putExtra(TASK_INPUT_EXTRA_TAG, userInput);
                startActivity(goToUserSettingsIntent);
            });


        }

//  TODO: Step 1-2: Grab the RecylcerView
    public void setUpRecyclerView(){
        // TODO: Step 2-2: Make some data items


        RecyclerView taskModelRecyclerView = findViewById(R.id.MainActivityRecyclerViewTaskModel);
//      TODO: Step 1-3: Set the layout manager of the RecyclerView to a LinearLayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        taskModelRecyclerView.setLayoutManager(layoutManager);
        // TODO: Step 1-5: Create and attach the RecyclerView.Adapter
        // TODO: Step 2-3: Hand in some data items
        // TODO: Step 3-2: Hand in the Activity context
        adapter = new TaskRecyclerViewAdapter(taskModelsList, this);
        taskModelRecyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = preferences.getString(USER_NAME_TAG, "No Username");
        ((TextView)findViewById(R.id.mainActivityTaskMasterTextView)).setText(username);
        taskModelsList.clear();
        taskModelsList.addAll(taskMasterDatabase.taskDao().findAll());
        adapter.notifyDataSetChanged();
    }
}