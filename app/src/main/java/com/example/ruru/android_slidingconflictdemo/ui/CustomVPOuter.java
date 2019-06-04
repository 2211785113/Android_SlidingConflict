package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import static android.view.MotionEvent.ACTION_MOVE;

/**
 * different outer
 * Created by SophieRu on 2019/5/9
 */
public class CustomVPOuter extends ViewPager {

    private int lastX;
    private int lastY;

    public CustomVPOuter(Context context) {
        super(context);
    }

    public CustomVPOuter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return true;
    }
}
