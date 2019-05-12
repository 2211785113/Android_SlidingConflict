package com.example.ruru.android_slidingconflictdemo.sameDirection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.example.ruru.android_slidingconflictdemo.R;
import com.example.ruru.android_slidingconflictdemo.adapter.SubRvAdapter;
import com.example.ruru.android_slidingconflictdemo.data.DataModel;

public class SV_RV_3 extends AppCompatActivity {

    private ScrollView scrollView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv_rv);

        initView();
        initData();
    }

    private void initView() {
        scrollView = findViewById(R.id.scrollView);
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new SubRvAdapter(this, DataModel.getStringList1()));
    }
}
