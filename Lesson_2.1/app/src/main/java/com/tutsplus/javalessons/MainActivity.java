package com.tutsplus.javalessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyLittleInterface mli = this::mySumCalculator;
        MyLittleInterface mli2 = this::mySumCalculator;

        int sum = mli.getSum("hello");

        Log.d(TAG, "Sum is " + sum);
    }
}
