package com.example.ruru.android_slidingconflictdemo.first_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ruru.android_slidingconflictdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by SophieRu on 2019/4/19
 */
public class RelativeLayout extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvDesc;
    private SimpleDraweeView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relativelayout);

        tvTitle = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);
        img = findViewById(R.id.iv_avatar);

        tvTitle.setText("你好");
        tvDesc.setText("阳光");
        img.setImageResource(R.mipmap.ic_launcher);
    }
}
