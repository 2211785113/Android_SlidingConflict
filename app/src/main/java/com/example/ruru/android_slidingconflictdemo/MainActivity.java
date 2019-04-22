package com.example.ruru.android_slidingconflictdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.example.ruru.android_slidingconflictdemo.first_demo.FirstActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void swipeAndView(View v) {
        startActivity(new Intent(this, FirstActivity.class));
    }
}
