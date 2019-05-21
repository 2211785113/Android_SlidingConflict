package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;

import java.util.Date;

/**
 * Created by SophieRu on 2019/5/21
 */
public class SRL_LV extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srl_lv);

        initView();
        initData();
    }

    private void initView() {
        mSwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        listView = findViewById(R.id.listView);
    }

    private void initData() {
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.item, R.id.tv, DataModel.getStringList1()));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Log.d("SRL_LV", "refreshTime=" + new Date().getTime());
                Log.d("SRL_LV", "swipeRefreshLayout 正在滚动");

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                Log.d("SRL_LV", "scrollTime=" + new Date().getTime());
                Log.d("SRL_LV", "listView 正在滚动");
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }
}
