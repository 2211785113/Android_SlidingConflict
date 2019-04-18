package com.example.ruru.android_slidingconflictdemo.first_demo;

import android.app.Activity;
import android.support.v4.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;

import com.example.ruru.android_slidingconflictdemo.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeAndViewActivity extends Activity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_and_view);

        initView();
    }

    private void initView() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        viewPager = findViewById(R.id.viewPager);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //执行刷新操作
            }
        });

        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new AFragment());
        list.add(new BFragment());

        viewPager.setAdapter(new SubPagerAdapter(this.getFragmentManager(), list));
    }


}
