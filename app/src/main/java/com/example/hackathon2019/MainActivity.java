package com.example.hackathon2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    public ViewFlipper signupFlipper;

    public Button prevButton;
    public Button nextButton;

    public int questionCount = 1;
    public final int[] numberOfQuestions = {3, 3, 2, 3};

    public int currentCategory = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupFlipper = findViewById(R.id.signup_flipper);

        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        if (questionCount <= 1) {
            prevButton.setClickable(false);
        }

//        Button addActivityBtn = findViewById(R.id.AddBtn);
//        addActivityBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText t1 = (EditText) findViewById(R.id.firstNumEditText);
//                float num1 = Float.parseFloat(t1.getText() + "");
//                TextView t2 = findViewById(R.id.secondNumEditText);
//                float num2 = Float.parseFloat(t2.getText() + "");
//                float res = num1 + num2;
//
//                TextView t3 = findViewById(R.id.resultLabel);
//                String resAsStr = getString(R.string.add_result, res);
//                t3.setText(resAsStr);
//            }
//        });

    }

    public void previousView(View v) {
        signupFlipper.setInAnimation(this, R.anim.slide_in_right);
        signupFlipper.setOutAnimation(this, R.anim.slide_out_left);
        signupFlipper.showPrevious();
        if (questionCount <= 1) {
            prevButton.setClickable(false);
        }
        else {
            prevButton.setClickable(true);
        }
        boolean flag;
        switch (currentCategory) {
            case 0: case 1: case 3:
                flag = (questionCount < 3);
                nextButton.setClickable(flag);
                break;
            case 2:
                flag = (questionCount < 2);
                nextButton.setClickable(flag);
                break;
            default:
                break;
        }
        questionCount--;
    }

    public void nextView(View v) {
        signupFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        signupFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        signupFlipper.showNext();
        if (questionCount <= 1) {
            prevButton.setClickable(false);
        }
        else {
            prevButton.setClickable(true);
        }
        boolean flag;
        switch (currentCategory) {
            case 0: case 1: case 3:
                flag = (questionCount < 2);
                nextButton.setClickable(flag);
                break;
            case 2:
                flag = (questionCount < 1);
                nextButton.setClickable(flag);
                break;
            default:
                break;
        }
        questionCount++;
    }
}
