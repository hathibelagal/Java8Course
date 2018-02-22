package com.tutsplus.javalessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyInterface {

    private static final String TAG = "MainActivity";

    @Override
    public String getAuthor() {
        return "Hathibelagal";
    }

    @Override
    public int getAuthorId() {
        return 1;
    }

    @FunctionalInterface
    interface MyLittleInterface {
        int getSum(String s);
    }

    private int mySumCalculator(String s) {
        int sum = 0;
        for(int i=0;i < s.length(); i++) {
            sum += (int)s.charAt(i);
        }
        return sum;
    }

    private boolean keyPressed(TextView v, int actionID, KeyEvent event) {
        if(actionID == EditorInfo.IME_ACTION_DONE) {
            Log.d(TAG, "keyPressed: User finished typing");
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyLittleInterface mli = this::mySumCalculator;
        MyLittleInterface mli2 = this::mySumCalculator;

        int sum = mli.getSum("hello");

        Log.d(TAG, "Sum is " + sum);

        Button myButton = findViewById(R.id.my_button);
        myButton.setOnClickListener((view) ->
            Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show()
        );

        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        input1.setOnEditorActionListener(this::keyPressed);
        input2.setOnEditorActionListener(this::keyPressed);

        MyInterface.getProjectId();
    }
}
