package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewTreeObserver;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubRvAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;

import java.util.Date;

public class SRL_RV extends AppCompatActivity {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srl_rv);

        initView();
        initData();
    }

    private void initView() {
        mRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = findViewById(R.id.recyclerView);
    }

    private void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new SubRvAdapter(this, DataModel.getStringList1()));

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mRefreshLayout.setRefreshing(false);
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

//                Log.d("SRL_RV", "recyclerViewTime=" + new Date().getTime());
                Log.d("SRL_RV", "recyclerView 正在滚动");
            }
        });

        mRefreshLayout.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                Log.d("SRL_RV", "swipeRefreshLayout 正在滚动");
            }
        });
    }
}
