package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRegisterButton(View view) {
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        nameTextView.setText("Name: " + editTextName.getText().toString());
        emailTextView.setText("Email: " + editTextEmail.getText().toString());
    }
}