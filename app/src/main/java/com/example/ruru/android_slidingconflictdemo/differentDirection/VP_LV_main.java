package com.example.ruru.android_slidingconflictdemo.differentDirection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubVpAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;
import com.example.ruru.android_slidingconflictdemo.ui.CustomVPOuter;

public class VP_LV_main extends AppCompatActivity {

    private CustomVPOuter viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_lv);

        initView();
        initData();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
    }

    private void initData() {
        viewPager.setAdapter(new SubVpAdapter(getSupportFragmentManager(), DataModel.getFragmentList4()));
    }
}

