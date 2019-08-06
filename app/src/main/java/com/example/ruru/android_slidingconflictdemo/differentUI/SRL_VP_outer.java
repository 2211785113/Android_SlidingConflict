package com.example.ruru.android_slidingconflictdemo.differentUI;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class SRL_VP_outer extends SwipeRefreshLayout {
    public SRL_VP_outer(Context context) {
        super(context);
    }

    public SRL_VP_outer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
