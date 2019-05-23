package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;

import java.util.Date;

public class SRL_SV extends AppCompatActivity {

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

                Log.d("SRL_SV", "refreshTime=" + new Date().getTime());

                mRefreshLayout.setRefreshing(false);
            }
        });

        mRefreshLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                Log.d("SRL_SV", "swipeRefreshLayout 正在滚动");
            }
        });

        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (mScrollView.getScrollY() == 0) {

                    Log.d("SRL_SV", "scrollTime=" + new Date().getTime());
                    Log.d("SRL_SV", "scrollView 正在滚动");

                }
            }
        });

    }
}
