package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubVpAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;

public class VP_VP extends AppCompatActivity {

    private ViewPager viewPager1;
    private ViewPager viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_vp);

        initView();
        initData();
    }

    private void initData() {
        viewPager1.setAdapter(new SubVpAdapter(getSupportFragmentManager(), DataModel.getFragmentList1()));
        viewPager2.setAdapter(new SubVpAdapter(getSupportFragmentManager(), DataModel.getFragmentList2()));
    }

    private void initView() {
        viewPager1 = findViewById(R.id.viewPager1);
        viewPager2 = findViewById(R.id.viewPager2);
    }
}
