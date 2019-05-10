package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by SophieRu on 2019/5/7
 */
public class CustomSRL extends SwipeRefreshLayout {

    public CustomSRL(Context context) {
        super(context);
    }

    public CustomSRL(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d("srl", "onTouchEvent++");
        return super.onTouchEvent(ev);
    }
}
