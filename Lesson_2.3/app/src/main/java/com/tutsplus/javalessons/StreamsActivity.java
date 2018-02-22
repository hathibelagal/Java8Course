package com.tutsplus.javalessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsActivity extends AppCompatActivity {

    private static final String TAG = "StreamsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streams);

        int myNumbers[] = {5, 10, 300, 90, 55};
        IntStream numbersStream = Arrays.stream(myNumbers);

        List<String> myStrings = new ArrayList<>();
        myStrings.add("what");
        myStrings.add("why");
        myStrings.add("how");

        Stream<String> stringStream = myStrings.stream();

        IntStream rangeStream = IntStream.range(50, 90);

        numbersStream.forEach(x -> {
            Log.d(TAG, "onCreate: Value is " + x);
        });

        stringStream.forEach(x -> {
            Log.d(TAG, "onCreate: String is " + x);
        });

        rangeStream.map(x -> 2 * x).forEach(x -> {
            Log.d(TAG, "onCreate: Doubled value is " + x);
        });
    }
}
