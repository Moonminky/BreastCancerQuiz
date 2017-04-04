package com.example.android.breastcancerquiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score, q1, q2, q3, q4, q5a1, q5a2, q5a3, q6, q7;

    //Hide Keyboard when not needed
    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    //Check and grade Radiobutton selection
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Q1A1:
                if (checked)
                    q1 = 1;
                break;
            case R.id.Q1A2:
                if (checked)
                    q1 = 0;
                break;
            case R.id.Q2A1:
                if (checked)
                    q2 = 1;
                break;
            case R.id.Q2A2:
                if (checked)
                    q2 = 0;
                break;
            case R.id.Q3A1:
                if (checked)
                    q3 = 0;
                break;
            case R.id.Q3A2:
                if (checked)
                    q3 = 0;
                break;
            case R.id.Q3A3:
                if (checked)
                    q3 = 1;
                break;
            case R.id.Q4A1:
                if (checked)
                    q4 = 0;
                break;
            case R.id.Q4A2:
                if (checked)
                    q4 = 1;
                break;
            case R.id.Q4A3:
                if (checked)
                    q4 = 0;
                break;
            case R.id.Q6A1:
                if (checked)
                    q6 = 0;
                break;
            case R.id.Q6A2:
                if (checked)
                    q6 = 1;
        }
    }

    //Check and grade Checkbox selection
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

    //Check EditText questions and Build score
    public void submitAnswers(View view) {
        EditText Q7 = (EditText) findViewById(R.id.Q7A1);
        String Q7A1 = Q7.getEditableText().toString();

        if (Q7A1.equalsIgnoreCase("Estrogen") || Q7A1.equalsIgnoreCase("Oestrogen") || Q7A1.equalsIgnoreCase("Estrogens") || Q7A1.equalsIgnoreCase("Oestrogens") || Q7A1.equalsIgnoreCase("östrogen")) {
            q7 = 1;
        }
        score = q1 + q2 + q3 + q4 + q5a1 + q5a2 + q5a3 + q6 + q7;
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
        } else if (score == 7) {
            Toast.makeText(getApplicationContext(), getString(R.string.resultPerfect), Toast.LENGTH_LONG).show();
        }
    }
}

