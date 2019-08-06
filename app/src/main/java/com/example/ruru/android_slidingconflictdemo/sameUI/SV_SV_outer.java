package com.example.ruru.android_slidingconflictdemo.sameUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class SV_SV_outer extends ScrollView {
    public SV_SV_outer(Context context) {
        super(context);
    }

    public SV_SV_outer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        return false;
    }
}
