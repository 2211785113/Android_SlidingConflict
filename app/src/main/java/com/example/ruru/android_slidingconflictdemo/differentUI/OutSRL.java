package com.example.ruru.android_slidingconflictdemo.differentUI;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class OutSRL extends SwipeRefreshLayout {

    public OutSRL(Context context) {
        super(context);
    }

    public OutSRL(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(getClass().getName(), "dispatchTouchEvent: ++");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(getClass().getName(), "onInterceptTouchEvent: ++");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(getClass().getName(), "onTouchEvent: ++");
        return super.onTouchEvent(ev);
    }
}
