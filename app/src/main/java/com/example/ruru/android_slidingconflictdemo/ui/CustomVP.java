package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import static android.view.MotionEvent.ACTION_MOVE;

/**
 * 外层
 * Created by SophieRu on 2019/5/9
 */
public class CustomVP extends ViewPager {

    private int lastX;
    private int lastY;

    public CustomVP(Context context) {
        super(context);
    }

    public CustomVP(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case ACTION_MOVE:
                int deltaX = x - lastX;
                int deltaY = y - lastY;
                if (deltaX > deltaY) {
                    return true;
                }
                break;
        }
        lastX = (int) ev.getX();
        lastY = (int) ev.getY();
        return false;
    }
}
