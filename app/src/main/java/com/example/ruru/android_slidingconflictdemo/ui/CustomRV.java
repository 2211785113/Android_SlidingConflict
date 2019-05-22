package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * sameDirection # SV_RV
 * <p>
 * Created by SophieRu on 2019/5/22
 */
public class CustomRV extends RecyclerView {

    public CustomRV(Context context) {
        super(context);
    }

    public CustomRV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
