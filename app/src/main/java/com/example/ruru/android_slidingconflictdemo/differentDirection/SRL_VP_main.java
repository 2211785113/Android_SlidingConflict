package com.example.ruru.android_slidingconflictdemo.differentDirection;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubVpAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;
import com.example.ruru.android_slidingconflictdemo.ui.CustomSRL1;
import com.example.ruru.android_slidingconflictdemo.ui.CustomSRL2;
import com.example.ruru.android_slidingconflictdemo.ui.CustomVPInner;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class SRL_VP_main extends AppCompatActivity {

    private CustomSRL2 swipeRefreshLayout;
    private CustomVPInner viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srl_vp);
        initView();
        initData();
    }

    private void initView() {
        swipeRefreshLayout = (CustomSRL2) findViewById(R.id.swipeRefreshLayout);
        viewPager = (CustomVPInner) findViewById(R.id.viewPager);
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
