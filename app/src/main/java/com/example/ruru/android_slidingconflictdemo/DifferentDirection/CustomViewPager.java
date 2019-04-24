package com.example.ruru.android_slidingconflictdemo.DifferentDirection;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by SophieRu on 2019/4/22
 */
public class CustomViewPager extends ViewPager {

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 需要仔细体会
     * 默认会向子View传递，如果由ViewPager拦截了此事件，请求不允许父View拦截事件。
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean in = super.onInterceptTouchEvent(ev);
        if (in) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }
}
