package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

/**
 * different outer
 * Created by SophieRu on 2019/5/7
 */
public class CustomSRL1 extends SwipeRefreshLayout {

    private boolean mIsBeingDragged;
    private float initialX;
    private float initialY;
    private float x;
    private float y;
    private float deltaX;
    private float deltaY;
    private int mTouchSlop;
    boolean isVpDragged = false;

    public CustomSRL1(Context context) {
        super(context);
    }

    public CustomSRL1(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = ev.getX();
                initialY = ev.getY();
                isVpDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                //只要手指不离开就一直返回false
                if (isVpDragged)
                    return false;
                x = ev.getX();
                y = ev.getY();
                deltaX = Math.abs(x - initialX);
                deltaY = Math.abs(y - initialY);
                if (deltaX > deltaY) {
                    isVpDragged = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isVpDragged = false;
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
