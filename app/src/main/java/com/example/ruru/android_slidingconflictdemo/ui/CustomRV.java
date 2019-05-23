package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * sameDirection # SV_RV
 * <p>
 * Created by SophieRu on 2019/5/22
 */
public class CustomRV extends RecyclerView {

    private CustomSV scrollView;

    private float mInitialDownY;
    private float y;
    private float diff;
    private int mTouchSlop;

    public CustomRV(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public CustomRV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                mInitialDownY = getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //子View滑动的时候要向子View传递。
                y = getY();
                diff = y - mInitialDownY;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
