package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubRvAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;
import com.example.ruru.android_slidingconflictdemo.sameUI.SV_RV_inner;
import com.example.ruru.android_slidingconflictdemo.sameUI.SV_RV_outer;

public class SV_RV extends AppCompatActivity {

    private SV_RV_outer mScrollView;
    private SV_RV_inner mRecyclerView;

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
    }
}
