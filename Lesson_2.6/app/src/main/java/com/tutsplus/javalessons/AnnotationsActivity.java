package com.tutsplus.javalessons;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class AnnotationsActivity extends AppCompatActivity {

    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Authors.class)
    @interface Author {
        String name();
        int age();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Authors {
        Author[] value();
    }

    @Author(name="Bob", age=30)
    @Author(name="Sam", age=40)
    @Author(name="Jane", age=50)
    class Book {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Author[] authors = Book.class.getAnnotationsByType(Author.class);
        Arrays.stream(authors).forEach(x -> {
            Log.d("AUTHOR", "Name = " + x.name() + " Age = " + x.age());
        });
    }
}
