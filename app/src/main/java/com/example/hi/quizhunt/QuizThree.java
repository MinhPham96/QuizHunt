package com.example.hi.quizhunt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class QuizThree extends AppCompatActivity {

    private Integer q3num = 0;
    private Integer result3 = 0;
    private int month = 0;
    private int day = 0;

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }   //prevent user from pressing back

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Quiz 3","now running onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Quiz 3","now running onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Quiz 3","now running onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Quiz 3","now running onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Quiz 3","now running onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Quiz 3","now running onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_three);
        Log.i("Quiz 3","now running onCreate()");

        //a year has 365 days, so the number will be randomized from 0 to 364 and plus 1
        Log.i("Quiz 3","Generate random number");
        Random r = new Random();
        q3num = r.nextInt(365) + 1;
        Log.i("Quiz 3","Number " + q3num + " is generated");

        //display the randomized number
        TextView textView = (TextView) findViewById(R.id.q3num);
        textView.setText( String.valueOf(q3num) );

        //create a calendar variable to listen to the user selection
        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int selectedMonth, int selectedDay) {
                Log.i("Quiz 3", "Check Calendar Input");
                month = selectedMonth + 1;      //selected month is from 0 to 11 (need to add 1)
                day = selectedDay;
                Log.i("Quiz 3", "Day selected " + day);
                Log.i("Quiz 3", "Month selected " + month);
            }//met
        });
    }

    public void calculate3(View view) {
        SharedPreferences sharedPref = this.getSharedPreferences("com.example.app",
                Context.MODE_PRIVATE);

        //based on the selected month
        //the selected month will include all the days of the previous months
        Log.i("Quiz 3","Perform calculation");
        switch(month) {
            default:
                Log.i("Quiz 3", "Month 1 selected, no additional day to total");
                result3 += 0;
                break;
            case 2:
                Log.i("Quiz 3", "Month 2 selected, add 31 days to total");
                result3 += 31;
                break;
            case 3:
                Log.i("Quiz 3", "Month 3 selected, add 59 days to total");
                result3 += 59;
                break;
            case 4:
                Log.i("Quiz 3", "Month 4 selected, add 90 days to total");
                result3 += 90;
                break;
            case 5:
                Log.i("Quiz 3", "Month 5 selected, add 120 days to total");
                result3 += 120;
                break;
            case 6:
                Log.i("Quiz 3", "Month 6 selected, add 151 days to total");
                result3 += 151;
                break;
            case 7:
                Log.i("Quiz 3", "Month 7 selected, add 181 days to total");
                result3 += 181;
                break;
            case 8:
                Log.i("Quiz 3", "Month 8 selected, add 212 days to total");
                result3 += 212;
                break;
            case 9:
                Log.i("Quiz 3", "Month 9 selected, add 243 days to total");
                result3 += 243;
                break;
            case 10:
                Log.i("Quiz 3", "Month 10 selected, add 273 days to total");
                result3 += 273;
                break;
            case 11:
                Log.i("Quiz 3", "Month 11 selected, add 304 days to total");
                result3 += 304;
                break;
            case 12:
                Log.i("Quiz 3", "Month 12 selected, add 334 days to total");
                result3 += 334;
                break;
        }
        Log.i("Quiz 3", "Add another " + day + " day(s) to total");
        result3 += day; //than the result will add the selected day
        Log.i("Quiz 3","The result is " + result3);

        if(result3.equals(q3num)) {
            Log.i("Quiz 3","Result is correct, write true to shared preference");
            sharedPref.edit().putBoolean("Quiz 3", true).apply();
            Toast.makeText(this, "Result is correct", Toast.LENGTH_LONG).show();
        }
        else {
            Log.i("Quiz 3","Result is incorrect, write false to shared preference");
            sharedPref.edit().putBoolean("Quiz 3", false).apply();
            Toast.makeText(this, "Result is incorrect", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(this, FinalResult.class);
        startActivity(intent);
        Log.i("Quiz 3","move to Final Result");
    }

//    public void moveToFinalResult(View view) {
//        Intent intent = new Intent(this, FinalResult.class);
//        startActivity(intent);
//    }
}
