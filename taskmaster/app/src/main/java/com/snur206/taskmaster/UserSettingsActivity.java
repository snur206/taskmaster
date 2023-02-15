package com.snur206.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserSettingsActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String USER_NAME_TAG = "userName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        Intent callingIntent = getIntent();
        String userInputString = null;
        if (callingIntent != null) {
            userInputString = callingIntent.getStringExtra(MainActivity.TASK_INPUT_EXTRA_TAG);
        }

        TextView userInputTextView = (TextView)findViewById(R.id.userSettingsActivityInputTextView);
        if (userInputString != null) {
            userInputTextView.setText(userInputString);
        } else {
            userInputTextView.setText(R.string.no_input);
        }



        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_NAME_TAG, "");
        EditText userNameEditText = (EditText) findViewById(R.id.userSettingsActivityUsernameEditTextView);
        userNameEditText.setText(userName);

        Button saveButton = findViewById(R.id.userSettingsActivitySaveBtn);
        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor preferencesEditor = preferences.edit();

            String userNameString = userNameEditText.getText().toString();

            preferencesEditor.putString(USER_NAME_TAG, userNameString);
            preferencesEditor.apply();

            Toast.makeText(UserSettingsActivity.this, "Settings saved!", Toast.LENGTH_SHORT).show();
        });
    }
}