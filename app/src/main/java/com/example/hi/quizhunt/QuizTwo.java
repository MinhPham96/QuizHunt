package com.example.hi.quizhunt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizTwo extends AppCompatActivity {

    //boolean flag for each radio button
    private boolean rbflag0 = false;
    private boolean rbflag1 = false;
    private boolean rbflag2 = false;
    private boolean rbflag3 = false;
    private boolean rbflag4 = false;
    private boolean rbflag5 = false;
    private boolean rbflag6 = false;
    private boolean rbflag7 = false;
    private Integer q2num = 0;          //generated number for quiz 2
    private Integer result2 = 0;        //user result for quiz 2

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }   //prevent user from pressing back

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Quiz 2","now running onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Quiz 2","now running onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Quiz 2","now running onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Quiz 2","now running onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Quiz 2","now running onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Quiz 2","now running onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_two);
        Log.i("Quiz 2","now running onCreate()");

        //generate a random number from 0 to 255 (because 2^8 = 256)
        Log.i("Quiz 2","Generate random number");
        Random r = new Random();
        q2num = r.nextInt(256);
        Log.i("Quiz 2","Number " + q2num + " is generated");

        //display the randomized number
        TextView textView = (TextView) findViewById(R.id.q2num);
        textView.setText( String.valueOf(q2num) );

        final RadioButton rb0 = (RadioButton) findViewById(R.id.radioButton0);
        final RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
        final RadioButton rb5 = (RadioButton) findViewById(R.id.radioButton5);
        final RadioButton rb6 = (RadioButton) findViewById(R.id.radioButton6);
        final RadioButton rb7 = (RadioButton) findViewById(R.id.radioButton7);

        //everytime the button is pressed
        //check the flag to turn the button on or off
        rb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb0.isChecked()) {
                    if (!rbflag0) {
                        rb0.setChecked(true);
                        rbflag0 = true;
                        Log.i("Quiz 2","Turn on radio button 0");
                    } else {
                        rb0.setChecked(false);
                        rbflag0 = false;
                        Log.i("Quiz 2","Turn off radio button 0");
                    }}}});

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1.isChecked()) {
                    if (!rbflag1) {
                        rb1.setChecked(true);
                        rbflag1 = true;
                        Log.i("Quiz 2","Turn on radio button 1");
                    } else {
                        rb1.setChecked(false);
                        rbflag1 = false;
                        Log.i("Quiz 2","Turn off radio button 1");
                    }}}});

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb2.isChecked()) {
                    if (!rbflag2) {
                        rb2.setChecked(true);
                        rbflag2 = true;
                        Log.i("Quiz 2","Turn on radio button 2");
                    } else {
                        rb2.setChecked(false);
                        rbflag2 = false;
                        Log.i("Quiz 2","Turn off radio button 2");
                    }}}});

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb3.isChecked()) {
                    if (!rbflag3) {
                        rb3.setChecked(true);
                        rbflag3 = true;
                        Log.i("Quiz 2","Turn on radio button 3");
                    } else {
                        rb3.setChecked(false);
                        rbflag3 = false;
                        Log.i("Quiz 2","Turn off radio button 3");
                    }}}});

        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb4.isChecked()) {
                    if (!rbflag4) {
                        rb4.setChecked(true);
                        rbflag4 = true;
                        Log.i("Quiz 2","Turn on radio button 4");
                    } else {
                        rb4.setChecked(false);
                        rbflag4 = false;
                        Log.i("Quiz 2","Turn off radio button 4");
                    }}}});

        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb5.isChecked()) {
                    if (!rbflag5) {
                        rb5.setChecked(true);
                        rbflag5 = true;
                        Log.i("Quiz 2","Turn on radio button 5");
                    } else {
                        rb5.setChecked(false);
                        rbflag5 = false;
                        Log.i("Quiz 2","Turn off radio button 5");
                    }}}});

        rb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb6.isChecked()) {
                    if (!rbflag6) {
                        rb6.setChecked(true);
                        rbflag6 = true;
                        Log.i("Quiz 2","Turn on radio button 6");
                    } else {
                        rb6.setChecked(false);
                        rbflag6 = false;
                        Log.i("Quiz 2","Turn off radio button 6");
                    }}}});

        rb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb7.isChecked()) {
                    if (!rbflag7) {
                        rb7.setChecked(true);
                        rbflag7 = true;
                        Log.i("Quiz 2","Turn on radio button 7");
                    } else {
                        rb7.setChecked(false);
                        rbflag7 = false;
                        Log.i("Quiz 2","Turn off radio button 7");
                    }}}});
    }

    public void calculate2(View view) {
        SharedPreferences sharedPref = this.getSharedPreferences("com.example.app",
                Context.MODE_PRIVATE);

        //depend on the flag of each radio button
        //the result will take account of each button is selected
        Log.i("Quiz 2","Perform calculation");
        for(int i = 0; i < 8; i++) {
            switch(i) {
                default:
                    if(rbflag0) {
                        result2 += 1;
                        Log.i("Quiz 2","Radio button 0 is selected, add 1");
                    }
                    break;
                case 1:
                    if(rbflag1) {
                        result2 += 2;
                        Log.i("Quiz 2","Radio button 1 is selected, add 2");
                    }
                    break;
                case 2:
                    if(rbflag2) {
                        result2 += 4;
                        Log.i("Quiz 2","Radio button 2 is selected, add 4");
                    }
                    break;
                case 3:
                    if(rbflag3) {
                        result2 += 8;
                        Log.i("Quiz 2","Radio button 3 is selected, add 8");
                    }
                    break;
                case 4:
                    if(rbflag4) {
                        result2 += 16;
                        Log.i("Quiz 2","Radio button 4 is selected, add 16");
                    }
                    break;
                case 5:
                    if(rbflag5) {
                        result2 += 32;
                        Log.i("Quiz 2","Radio button 5 is selected, add 32");
                    }
                    break;
                case 6:
                    if(rbflag6) {
                        result2 += 64;
                        Log.i("Quiz 2","Radio button 6 is selected, add 64");
                    }
                    break;
                case 7:
                    if(rbflag7) {
                        result2 += 128;
                        Log.i("Quiz 2","Radio button 7 is selected, add 128");
                    }
                    break;
            }
        }
        Log.i("Quiz 2","The result is " + result2);

        if(result2.equals(q2num)) {
            Log.i("Quiz 2","Result is correct, write true to shared preference");
            sharedPref.edit().putBoolean("Quiz 2", true).apply();
            Toast.makeText(this, "Result is correct", Toast.LENGTH_LONG).show();
        }
        else {
            Log.i("Quiz 2","Result is incorrect, write false to shared preference");
            sharedPref.edit().putBoolean("Quiz 2", false).apply();
            Toast.makeText(this, "Result is incorrect", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(this, QuizThree.class);
        startActivity(intent);
        Log.i("Quiz 2","move to Quiz 3");
    }

//    public void moveToQuizThree(View view) {
//        Intent intent = new Intent(this, QuizThree.class);
//        startActivity(intent);
//    }
}
