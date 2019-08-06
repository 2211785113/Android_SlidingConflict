package com.example.ruru.android_slidingconflictdemo.sameUI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class SV_LV_inner extends RecyclerView {
    public SV_LV_inner(Context context) {
        super(context);
    }

    public SV_LV_inner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
