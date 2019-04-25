package com.example.ruru.android_slidingconflictdemo.differentDirection;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubAdapter;
import com.example.ruru.android_slidingconflictdemo.fragment.AFragment;
import com.example.ruru.android_slidingconflictdemo.fragment.BFragment;
import com.example.ruru.android_slidingconflictdemo.ui.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

public class SRL_VP extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private CustomViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srl_vp);

        initView();
        initData();
        refresh();
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    private void initData() {
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new AFragment());
        list.add(new BFragment());

        viewPager.setAdapter(new SubAdapter(getSupportFragmentManager(), list));
        tabLayout.setupWithViewPager(viewPager);

        //第一种
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(getClass().getName(), "action=" + event.getAction());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE://2
                        swipeRefreshLayout.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_UP://1
                    case MotionEvent.ACTION_CANCEL://3
                        swipeRefreshLayout.setEnabled(true);
                        break;
                }
                return false;
            }
        });
    }

    private void refresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //执行刷新操作
                System.out.println("刷新");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        swipeRefreshLayout.clearAnimation();
    }
}
