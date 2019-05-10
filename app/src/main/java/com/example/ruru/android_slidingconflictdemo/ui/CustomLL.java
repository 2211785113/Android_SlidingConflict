package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

/**
 * Created by SophieRu on 2019/5/7
 */
public class CustomLL extends LinearLayout {
    public CustomLL(Context context) {
        super(context);
    }

    public CustomLL(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("mt", "onTouchEvent++");
        switch (event.getAction()) {
            case ACTION_DOWN:
                Log.d("mt", "onTouchEvent: down");
                break;
            case ACTION_MOVE:
                Log.d("mt", "onTouchEvent: move");
                break;
            case ACTION_UP:
                Log.d("mt", "onTouchEvent: up");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
