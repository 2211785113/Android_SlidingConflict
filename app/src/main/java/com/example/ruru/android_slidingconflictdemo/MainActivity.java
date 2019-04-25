package com.example.ruru.android_slidingconflictdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ruru.android_slidingconflictdemo.differentDirection.LV_VP;
import com.example.ruru.android_slidingconflictdemo.differentDirection.SRL_VP;
import com.example.ruru.android_slidingconflictdemo.differentDirection.SV_VP;
import com.example.ruru.android_slidingconflictdemo.differentDirection.VP_LV;
import com.example.ruru.android_slidingconflictdemo.sameDirection.SRL_LV;
import com.example.ruru.android_slidingconflictdemo.sameDirection.SRL_SV;
import com.example.ruru.android_slidingconflictdemo.sameDirection.SV_LV;
import com.example.ruru.android_slidingconflictdemo.sameDirection.VP_VP;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //SameDirection
    public void SRL_SV(View v) {
        startActivity(new Intent(this, SRL_SV.class));
    }

    public void SV_LV(View v) {
        startActivity(new Intent(this, SV_LV.class));
    }

    public void SRL_LV(View v) {
        startActivity(new Intent(this, SRL_LV.class));
    }

    public void VP_VP(View v) {
        startActivity(new Intent(this, VP_VP.class));
    }

    //DifferentDirection
    public void SRL_VP(View v) {
        startActivity(new Intent(this, SRL_VP.class));
    }

    public void SV_VP(View v) {
        startActivity(new Intent(this, SV_VP.class));
    }

    public void LV_VP(View v) {
        startActivity(new Intent(this, LV_VP.class));
    }

    public void VP_LV(View v) {
        startActivity(new Intent(this, VP_LV.class));
    }
}
