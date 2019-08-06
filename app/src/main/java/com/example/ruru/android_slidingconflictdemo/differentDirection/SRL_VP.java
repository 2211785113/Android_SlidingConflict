package com.example.ruru.android_slidingconflictdemo.differentDirection;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubVpAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;
import com.example.ruru.android_slidingconflictdemo.differentUI.SRL_VP_out_SRL;
import com.example.ruru.android_slidingconflictdemo.differentUI.SRL_VP_outer;
import com.example.ruru.android_slidingconflictdemo.differentUI.SRL_VP_inner;

public class SRL_VP extends AppCompatActivity {

    private SRL_VP_outer swipeRefreshLayout;
    private SRL_VP_inner viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srl_vp);
        initView();
        initData();
    }

    private void initView() {
        swipeRefreshLayout = (SRL_VP_outer) findViewById(R.id.swipeRefreshLayout);
        viewPager = (SRL_VP_inner) findViewById(R.id.viewPager);
    }

    private void initData() {
        viewPager.setAdapter(new SubVpAdapter(getSupportFragmentManager(), DataModel.getFragmentList1()));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
