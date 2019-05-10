package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * 内层
 * Created by SophieRu on 2019/5/9
 */
public class CustomLV extends ListView {

    private int lastX;
    private int lastY;

    public CustomLV(Context context) {
        super(context);
    }

    public CustomLV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - lastX;
                int deltaY = y - lastY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        lastX = (int) ev.getX();
        lastY = (int) ev.getY();

        return super.dispatchTouchEvent(ev);
    }
}
