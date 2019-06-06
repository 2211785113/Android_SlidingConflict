package com.example.ruru.android_slidingconflictdemo.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

/**
 * 不同方向5-内层
 * Created by SophieRu on 2019/5/9
 */
public class CustomLV extends ListView {

    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private float diffX;
    private float diffY;

    public CustomLV(Context context) {
        super(context);
    }

    public CustomLV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                //如果它这里不设置那事件就被父View拦截了。
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case ACTION_MOVE:
                endX = ev.getX();
                endY = ev.getY();
                diffX = Math.abs(endX - startX);
                diffY = Math.abs(endY - startY);
                if (diffX > diffY)
                    getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case ACTION_UP:
            case ACTION_CANCEL:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
