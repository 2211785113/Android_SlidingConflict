package com.example.ruru.android_slidingconflictdemo.sameUI;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class VP_VP_inner extends ViewPager {

    public VP_VP_inner(Context context) {
        super(context);
    }

    public VP_VP_inner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        /*switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int curPosition = this.getCurrentItem();
                int count = this.getAdapter().getCount();
                if (curPosition == count - 1 || curPosition == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }*/
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("VP_VP", "dispatchTouchEvent: 内部在滑动++");
        }
        return super.dispatchTouchEvent(ev);
    }
}
