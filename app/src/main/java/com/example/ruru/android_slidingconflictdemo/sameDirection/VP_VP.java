package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubVpAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;
import com.example.ruru.android_slidingconflictdemo.ui.CustomVPSame;

public class VP_VP extends AppCompatActivity {

    private ViewPager mViewPager1;
    private CustomVPSame mViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_vp);

        initView();
        initData();
    }

    private void initData() {
        mViewPager1.setAdapter(new SubVpAdapter(getSupportFragmentManager(), DataModel.getFragmentList1()));
        mViewPager2.setAdapter(new SubVpAdapter(getSupportFragmentManager(), DataModel.getFragmentList2()));
    }

    private void initView() {
        mViewPager1 = findViewById(R.id.viewPager1);
        mViewPager2 = findViewById(R.id.viewPager2);
    }
}
