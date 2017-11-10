package com.example.hi.quizhunt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.R.id.list;
import static java.lang.Float.parseFloat;

public class QuizOne extends AppCompatActivity {

    //create variables
    private Integer operator = 0;       //the position number of the operator
    private Integer num1 = 2;           //first number
    private Integer num2 = 2;           //second number
    private Integer q1num = 0;          //the question number
    private boolean isPrime = true;     //check if the given number is prime
    private Integer result = 0;         //the calculated result
    private int max = 250;              //maximum input value
    private int min = 2;                //minimum input value

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }   //prevent user from pressing back

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Quiz 1","now running onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Quiz 1","now running onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Quiz 1","now running onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Quiz 1","now running onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Quiz 1","now running onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Quiz 1","now running onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_one);
        Log.i("Quiz 1","now running onCreate()");

        Log.i("Quiz 1","Generate Spinner");
        //add item in strings.xml into the spinner
        Spinner spinner = (Spinner) findViewById(R.id.operation);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.q1operations, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        Log.i("Quiz 1","Spinner generated");

        Log.i("Quiz 1","Generate random number");
        //randomize a number and check if it is a prime number
        do {
            Random r = new Random();
            q1num = r.nextInt(500 - 50) + 50;
            for(int i = 2; i < q1num; i++) {if(q1num % i == 0) {isPrime = false;}}
        } while(isPrime);
        Log.i("Quiz 1","Number " + q1num + " is generated");

        //display the randomized number
        TextView textView = (TextView) findViewById(R.id.q1num);
        textView.setText( String.valueOf(q1num) );

        //initialize the two edit texts to prevent error
        EditText editText = (EditText) findViewById(R.id.num1);
        EditText editText2 = (EditText) findViewById(R.id.num2);
        editText.setText(String.valueOf(num1));
        editText2.setText(String.valueOf(num2));

        //detect if the input exceeds maximum  or below minimum after user press Done in the edit text
        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Log.i("Quiz 1","Check inputs");
                    checkNum();
                    Log.i("Quiz 1","Check done");
                    return true;
                }
                return false;
            }
        });

        editText2.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Log.i("Quiz 1","Check inputs");
                    checkNum();
                    Log.i("Quiz 1","Check done");
                    return true;
                }
                return false;
            }
        });
    }



    public void calculate(View view) {
        //get the position of the selected operator in the spinner
        Spinner spinner = (Spinner) findViewById(R.id.operation);
        Log.i("Quiz 1","Get operator value from Spinner");
        operator = spinner.getSelectedItemPosition();
        Log.i("Quiz 1","Selected operator is " + operator);
        SharedPreferences sharedPref = this.getSharedPreferences("com.example.app",
                Context.MODE_PRIVATE);

        //get the two numbers from the edit text
        EditText editText = (EditText) findViewById(R.id.num1);
        EditText editText2 = (EditText) findViewById(R.id.num2);
        Log.i("Quiz 1","Get inputs from users");
        num1 = Integer.parseInt(editText.getText().toString());
        Log.i("Quiz 1","First number is " + num1);
        num2 = Integer.parseInt(editText2.getText().toString());
        Log.i("Quiz 1","Second number is " + num2);

        Log.i("Quiz 1","Perform calculation");
        //perform calculation based on the operator
        switch(operator) {
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
            case 2:
                result = num1 * num2;
                break;
            case 3:
                result = num1 / num2;
                break;
        }
        Log.i("Quiz 1","The result is " + result);

        //check if the result match the given number
        if(result.equals(q1num)) {
            Log.i("Quiz 1","Result is correct, write true to shared preference");
            //save as a boolean in the shared preference
            sharedPref.edit().putBoolean("Quiz 1", true).apply();
            //make a toast to notify the result for user
            Toast.makeText(this, "Result is correct", Toast.LENGTH_LONG).show();
        }
        else {
            Log.i("Quiz 1","Result is incorrect, write false to shared preference");
            sharedPref.edit().putBoolean("Quiz 1", false).apply();
            Toast.makeText(this, "Result is incorrect", Toast.LENGTH_LONG).show();
        }
        //move to quiz 2
        Intent intent = new Intent(this, QuizTwo.class);
        startActivity(intent);
        Log.i("Quiz 1","move to Quiz 2");
    }

    //check if input number exceeds 100
    public void checkNum() {
        EditText editText = (EditText) findViewById(R.id.num1);
        EditText editText2 = (EditText) findViewById(R.id.num2);

        //check if the input is null, if yes, set as minimum number
        if (editText.getText().toString().equals("")) {
            Log.i("Quiz 1","User enter null for first number, change value to min");
            editText.setText(String.valueOf(min));
        }
        if (editText2.getText().toString().equals("")) {
            Log.i("Quiz 1","User enter null for second number, change value to min");
            editText2.setText(String.valueOf(min));
        }

        //check if the input is above max or below min
        //set it as max and min respectively
        num1 = Integer.parseInt(editText.getText().toString());
        if(num1 > max) {
            Log.i("Quiz 1","First number exceeds max, change value to max");
            num1 = max;
            editText.setText(String.valueOf(num1));
        }
        else if (num1 < min) {
            Log.i("Quiz 1","First number is below min, change value to min");
            num1 = min;
            editText.setText(String.valueOf(num1));
        }

        num2 = Integer.parseInt(editText2.getText().toString());
        if(num2 > max) {
            Log.i("Quiz 1","Second number exceeds max, change value to max");
            num2 = max;
            editText2.setText(String.valueOf(num2));
        }
        else if (num2 < min) {
            Log.i("Quiz 1","Second number is below min, change value to min");
            num2 = min;
            editText2.setText(String.valueOf(num2));
        }
    }

//    public void moveToQuizTwo(View view) {
//        Intent intent = new Intent(this, QuizTwo.class);
//        startActivity(intent);
//    }

}
