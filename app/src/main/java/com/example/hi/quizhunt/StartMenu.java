package com.example.hi.quizhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StartMenu extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Start Menu","now running onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Start Menu","now running onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Start Menu","now running onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Start Menu","now running onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Start Menu","now running onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Start Menu","now running onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        Log.i("Start Menu","now running onCreate()");
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void moveToQuizOne(View view) {
        Intent intent = new Intent(this, QuizOne.class);
        startActivity(intent);
        Log.i("Start Menu","move to Quiz 1");
    }
}
