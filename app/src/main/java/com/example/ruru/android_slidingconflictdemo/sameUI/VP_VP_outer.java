package com.example.ruru.android_slidingconflictdemo.sameUI;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class VP_VP_outer extends ViewPager {
    public VP_VP_outer(Context context) {
        super(context);
    }

    public VP_VP_outer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("VP_VP", "onInterceptTouchEvent: 外部在滑动+");
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("VP_VP", "onInterceptTouchEvent: 外部在滑动++");
        }
        return super.onTouchEvent(ev);
    }
}
