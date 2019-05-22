package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by SophieRu on 2019/5/22
 */
public class CustomSV extends ScrollView {
    public CustomSV(Context context) {
        super(context);
    }

    public CustomSV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
