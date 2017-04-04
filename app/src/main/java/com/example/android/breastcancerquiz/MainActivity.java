package com.example.android.breastcancerquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score, q1, q2, q3, q4, q5a1, q5a2, q5a3, q6, q7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This code should
     * run through each question in the app,
     * record whether the user got the question right
     * and then display the quiz results in a Toast message.
     */

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Q1A1:
                if (checked)
                    // Pirates are the best
                    q1 = 1;
                break;
            case R.id.Q1A2:
                if (checked)
                    // Ninjas rule
                    q1 = 0;
                break;
            case R.id.Q2A1:
                if (checked)
                    // Ninjas rule
                    q2 = 1;
                break;
            case R.id.Q2A2:
                if (checked)
                    // Ninjas rule
                    q2 = 0;
                break;
            case R.id.Q3A1:
                if (checked)
                    // Ninjas rule
                    q3 = 0;
                break;
            case R.id.Q3A2:
                if (checked)
                    // Ninjas rule
                    q3 = 0;
                break;
            case R.id.Q3A3:
                if (checked)
                    // Ninjas rule
                    q3 = 1;
                break;
            case R.id.Q4A1:
                if (checked)
                    // Ninjas rule
                    q4 = 0;
                break;
            case R.id.Q4A2:
                if (checked)
                    // Ninjas rule
                    q4 = 1;
                break;
            case R.id.Q4A3:
                if (checked)
                    // Ninjas rule
                    q4 = 0;
                break;
            case R.id.Q6A1:
                if (checked)
                    // Ninjas rule
                    q6 = 0;
                break;
            case R.id.Q6A2:
                if (checked)
                    // Ninjas rule
                    q6 = 1;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.Q5A1:
                if (checked)
                    q5a1 = 1;
                else
                    q5a1 = 0;
                break;
            case R.id.Q5A2:
                if (checked)
                    q5a2 = 1;
                else
                    q5a2 = 0;
            case R.id.Q5A3:
                if (checked)
                    q5a3 = -1;
                else
                    q5a3 = 0;
                break;
        }
    }

    //Build score
    public void submitAnswers(View view) {
        EditText Q7 = (EditText) findViewById(R.id.Q7A1);
        String Q7A1 = Q7.getEditableText().toString();

        if (Q7A1.equalsIgnoreCase("Estrogen") || Q7A1.equalsIgnoreCase("Oestrogen") || Q7A1.equalsIgnoreCase("Estrogens") || Q7A1.equalsIgnoreCase("Oestrogens") || Q7A1.equalsIgnoreCase("östrogen")) {
            q7 = 1;
        }
        score = q1 + q2 + q3 + q4 + q5a1 + q5a2 + q5a3 + q6 + q7;
        Log.d("score", "score: " + score);
        showResults(score);
    }


    //Display results in a toast
    public void showResults(int score) {
        if (score < 4) {
            Toast.makeText(getApplicationContext(), getString(R.string.resultLess4, score), Toast.LENGTH_LONG).show();
        }
        if (score > 3 && score < 5) {
            Toast.makeText(getApplicationContext(), getString(R.string.resultLess5, score), Toast.LENGTH_LONG).show();
        }
        if (score > 5 && score < 7) {
            Toast.makeText(getApplicationContext(), getString(R.string.resultMore5, score), Toast.LENGTH_LONG).show();
        }
        else  if (score ==7) {
            Toast.makeText(getApplicationContext(), getString(R.string.resultPerfect), Toast.LENGTH_LONG).show();
        }
    }
}

