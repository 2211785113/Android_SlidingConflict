package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import com.example.ruru.android_slidingconflictdemo.R;

import java.util.Date;

public class SRL_SV_1 extends AppCompatActivity {

    private SwipeRefreshLayout mRefreshLayout;
    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srl_sv);

        mRefreshLayout = findViewById(R.id.mRefreshLayout);
        mScrollView = findViewById(R.id.mScrollView);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(getClass().getName(), "onRefresh:refresh time=" + new Date().getTime());
                mRefreshLayout.setRefreshing(false);
            }
        });

        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (mScrollView.getScrollY() == 0)
                    Log.d(getClass().getName(), "onScrollChanged:scroll time=" + new Date().getTime());
            }
        });
    }
}
