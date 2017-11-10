package com.example.hi.quizhunt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {

    private boolean final_result1;
    private boolean final_result2;
    private boolean final_result3;
    private float star = 0;

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Final Result","now running onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Final Result","now running onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Final Result","now running onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Final Result","now running onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Final Result","now running onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Final Result","now running onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        Log.i("Final Result","now running onCreate()");

        SharedPreferences sharedPref = this.getSharedPreferences("com.example.app",
                Context.MODE_PRIVATE);
        Log.i("Final Result","get result of each quiz");
        //get the boolean result of each quiz from the shared preferences
        final_result1 = sharedPref.getBoolean("Quiz 1", false);
        final_result2 = sharedPref.getBoolean("Quiz 2", false);
        final_result3 = sharedPref.getBoolean("Quiz 3", false);
        Log.i("Final Result","Quiz 1 " + final_result1);
        Log.i("Final Result","Quiz 2 " + final_result2);
        Log.i("Final Result","Quiz 3 " + final_result3);

        TextView textview = (TextView) findViewById(R.id.result1);
        TextView textview2 = (TextView) findViewById(R.id.result2);
        TextView textview3 = (TextView) findViewById(R.id.result3);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        //if the result is correct, a star will be added
        if(final_result1) {
            textview.setText("Quiz 1: Correct");
            star += 1;
        }
        else {
            textview.setText("Quiz 1: Incorrect");
        }

        if(final_result2) {
            textview2.setText("Quiz 2: Correct");
            star += 1;
        }
        else {
            textview2.setText("Quiz 2: Incorrect");
        }

        if(final_result3) {
            textview3.setText("Quiz 3: Correct");
            star += 1;
        }
        else {
            textview3.setText("Quiz 3: Incorrect");
        }
        Log.i("Final Result","Number of star " + star);
        //set the number of star to the rating bar
        ratingBar.setRating(star);
    }

    public void moveToHome(View view) {
        Intent intent = new Intent(this, StartMenu.class);
        startActivity(intent);
        Log.i("Final Result","move to Start Menu");
    }

}
