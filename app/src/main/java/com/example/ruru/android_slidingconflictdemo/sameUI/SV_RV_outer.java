package com.example.ruru.android_slidingconflictdemo.sameUI;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class SV_RV_outer extends ScrollView {

    public SV_RV_outer(Context context) {
        super(context);
    }

    public SV_RV_outer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("SV_RV", "onInterceptTouchEvent: 外层在滑动+");
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("SV_RV", "onInterceptTouchEvent: 外层在滑动++");
        }
        return super.onTouchEvent(ev);
    }
}
