package com.example.ruru.android_slidingconflictdemo.differentDirection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.differentUI.OutSRL;
import com.example.ruru.android_slidingconflictdemo.differentUI.SRL_VP_inner;
import com.example.ruru.android_slidingconflictdemo.differentUI.SRL_VP_outer;

public class OuterTestActivity extends AppCompatActivity {

    private OutSRL swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outer_test);

        initView();
    }

    private void initView() {
        swipeRefreshLayout = (OutSRL) findViewById(R.id.swipeRefreshLayout);
    }
}
