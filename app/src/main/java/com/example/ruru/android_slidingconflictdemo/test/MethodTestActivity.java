package com.example.ruru.android_slidingconflictdemo.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.ui.CustomLL;

public class MethodTestActivity extends AppCompatActivity {

    private CustomLL ll;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_test);

        initView();
        initData();
    }

    private void initData() {
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("mt", "onTouch++");
                return false;
            }
        });

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mt", "onClick++");
            }
        });
    }

    private void initView() {
        ll = findViewById(R.id.ll);
        button = findViewById(R.id.button);
    }
}
