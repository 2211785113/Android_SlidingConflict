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
    private int mTouchSlop;

    private boolean mIsVpDragger;
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private float diffY;
    private float diffX;

    public CustomSRL1(Context context) {
        super(context);
    }

    public CustomSRL1(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /**
     * 场景：srl能滑动，但是vp左下和右下滑动时事件被srl拦截。
     * 解决办法：仿srl源码当y轴大于x轴且y轴大于touchslop时拦截。
     */
    /*@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = ev.getX();
                initialY = ev.getY();
                mIsBeingDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                x = ev.getX();
                y = ev.getY();
                float deltaX = Math.abs(x - initialX);
                float deltaY = Math.abs(y - initialY);

                if (deltaY > deltaX || deltaY > mTouchSlop) {
                    mIsBeingDragged = true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mIsBeingDragged = false;
                break;
        }
        return mIsBeingDragged;
    }*/

    /**
     * 场景：srl能上下滑动。vp左下右下滑动srl拦截了事件。
     * 解决：srl当y轴大于touchslop时拦截事件。但是如果vp左右滑动，则事件要传给子View。
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                mIsVpDragger = false;
                break;
            case ACTION_MOVE:
                if (mIsVpDragger)
                    return false;

                endX = ev.getX();
                endY = ev.getY();
                diffY = Math.abs(endY - startY);
                diffX = Math.abs(endX - startX);
                if (diffX > mTouchSlop && diffX > diffY) {
                    mIsVpDragger = true;
                    return false;
                }
                break;
            case ACTION_UP:
            case ACTION_CANCEL:
                mIsVpDragger = false;
                break;
        }
        //Y轴位移大于X轴，事件交给SRL处理。
        return super.onInterceptTouchEvent(ev);
    }
}
