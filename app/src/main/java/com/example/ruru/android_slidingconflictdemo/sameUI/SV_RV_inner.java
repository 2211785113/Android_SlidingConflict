package com.example.ruru.android_slidingconflictdemo.sameUI;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class SV_RV_inner extends RecyclerView {

    public SV_RV_inner(Context context) {
        super(context);
    }

    public SV_RV_inner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("SV_RV", "dispatchTouchEvent: 内层在滑动++");
        }
        return super.dispatchTouchEvent(ev);
    }
}
