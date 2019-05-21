package com.example.ruru.android_slidingconflictdemo.differentDirection;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubVpAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;

public class SV_VP extends AppCompatActivity {

    private ScrollView scrollView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv_vp);

        initView();
        initData();
    }

    private void initView() {
        scrollView = findViewById(R.id.scrollView);
        viewPager = findViewById(R.id.viewPager);
    }

    private void initData() {
        viewPager.setAdapter(new SubVpAdapter(getSupportFragmentManager(), DataModel.getFragmentList1()));
    }

}
