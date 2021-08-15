package com.example.uibasics3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxEating, checkBoxSleeping, checkBoxPlaying;
    private RadioGroup radioGroupMood;

    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxEating = findViewById(R.id.checkboxEating);
        checkBoxPlaying = findViewById(R.id.checkboxPlaying);
        checkBoxSleeping = findViewById(R.id.checkboxSleeping);

        radioGroupMood = findViewById(R.id.mood);

        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressBar2.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();

        int checkedRadioButtonId = radioGroupMood.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.radioButtonHappy:
                Toast.makeText(MainActivity.this, "You are happy, congratulations!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButtonUnhappy:
                Toast.makeText(MainActivity.this, "Be happy my friend!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButtonDontKnow:
                Toast.makeText(MainActivity.this, "Learn to know yourself, that's important!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        radioGroupMood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonHappy:
                        Toast.makeText(MainActivity.this, "You are happy, congratulations!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.radioButtonUnhappy:
                        Toast.makeText(MainActivity.this, "Be happy my friend!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        break;
                    case R.id.radioButtonDontKnow:
                        Toast.makeText(MainActivity.this, "Learn to know yourself, that's important!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                    default:
                        break;
                }
            }
        });

        if (checkBoxEating.isChecked()) {
            Toast.makeText(MainActivity.this, "You have ate.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You need to eat.", Toast.LENGTH_SHORT).show();
        }

        checkBoxEating.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You have ate.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You need to eat.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}