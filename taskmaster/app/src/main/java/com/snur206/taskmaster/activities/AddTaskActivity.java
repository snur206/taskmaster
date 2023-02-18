package com.snur206.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.snur206.taskmaster.R;
import com.snur206.taskmaster.database.TaskMasterDatabase;
import com.snur206.taskmaster.model.TaskModel;

import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {
    TaskMasterDatabase taskMasterDatabase;
    Spinner taskStateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        taskStateSpinner = findViewById(R.id.taskStateSpinner);
        taskMasterDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskMasterDatabase.class,
                        MainActivity.DATABASE_TITLE)
                .fallbackToDestructiveMigration() // If Room gets confused, it tosses your database; don't use this in production!
                .allowMainThreadQueries()
                .build();
        setupTypeSpinner();
        setupSaveBtn();

        Button addTaskButton = (Button) findViewById(R.id.addTaskActivityBtn);

//        addTaskButton.setOnClickListener(new View.OnClickListener() {
//             @Override
//            public void onClick(View v) {
//                 TextView submittedTextView = (TextView) findViewById(R.id.addTaskActivitySumittedTextView);
//                 submittedTextView.setVisibility(View.VISIBLE);
//            }
//        });

    }
    // TODO: Step 5-4: setup spinner for enum
    public void setupTypeSpinner() {
        taskStateSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TaskModel.TaskStateEnum.values()
        ));
    }

    // TODO: Step 5-5: save taskModel to database onClick w/ DAO
    public void setupSaveBtn(){
        // set OnClick listener on BTN
        findViewById(R.id.addTaskActivityBtn).setOnClickListener(v -> {
            // gather all info
            TaskModel newTaskModel = new TaskModel (
                    ((EditText)findViewById(R.id.addTaskTitleEdit)).getText().toString(),
                    TaskModel.TaskStateEnum.fromString(taskStateSpinner.getSelectedItem().toString()),
                    new Date(),
                    ((EditText) findViewById(R.id.addTaskActivityTaskDecriptionEdit)).getText().toString()
            );
            // Save it to the DB
            taskMasterDatabase.taskDao().insertTask(newTaskModel);
            Toast.makeText(this, "Task Added!", Toast.LENGTH_SHORT).show();
        });
    }
}