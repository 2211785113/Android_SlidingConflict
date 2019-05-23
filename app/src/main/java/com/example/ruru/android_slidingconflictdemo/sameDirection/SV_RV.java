package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubRvAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;
import com.example.ruru.android_slidingconflictdemo.ui.CustomRV;
import com.example.ruru.android_slidingconflictdemo.ui.CustomSV;

public class SV_RV extends AppCompatActivity {

    private ScrollView mScrollView;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv_rv);

        initView();
        initData();
    }

    private void initView() {
        mScrollView = findViewById(R.id.scrollView);
        mRecyclerView = findViewById(R.id.recyclerView);
    }

    private void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new SubRvAdapter(this, DataModel.getStringList1()));

        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

                Log.d("SV_RV", "mScrollView 正在滚动");
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                Log.d("SV_RV", "mRecyclerView 正在滚动");
            }
        });
    }
}
