# Android_SlidingConflictDemo
## 同方向和不同方向的Android滑动冲突解决方案

### 说明：
为了文章简洁，下面将用简写代替控件或方法全称。

总控件：
* VG 代替 ViewGroup

纵向控件：
* SRL 代替 SwipeRefreshLayout
* TL 代替 TabLayout
* SV 代替 ScrollView
* RV 代替 RecyclerView
* LV 代替 ListView

横向控件：
* VP 代替 ViewPager
* SM 代替 SlideMenu


### 事件传递：
* disTE 代替 dispatchTouchEvent（事件分发）
* onITE 代替 onInterceptTouchEvent（事件拦截）
* onTE 代替 onTouchEvent（事件消费）
* reDITE 代替 requestDisallowInterceptTouchEvent（子View要求父View不要拦截事件）
* setOTL 代替 setOnTouchListener

<br/>

如果大家不了解View的事件分发机制，可以参看文章：

深度理解Android事件分发机制：https://www.jianshu.com/p/80a1bb7ced57

事件冲突实际上就是对事件分发机制的应用。


### 解决事件冲突总结来看有下列几种方法：
* 父View # onITE 方法：决定事件是否向子View传递。
* 子View # disTE 方法：通过 reDITE 来干预父View事件的分发。
* 子View # setOTL 方法：通过 reDITE 来干预父View事件的分发。
* 注意：标志位在MOVE事件和DOWN事件中都会起作用。


### 滑动冲突分为三种情况：
* 同方向；
* 不同方向；
* 同方向和不同方向混合。


### 同方向：
核心要点：
* 保证外部滑动的时候只滑动外部，内部滑动的时候只滑动内部。
* 点击事件交给合适的View处理。

冲突场景：
* 只有一层能滑动；
* 内外层同时滑动很卡顿。

<br/>

1.SRL+SV/RV：没有冲突。

分析：

SRL：重写了onITE方法。向下滑动，Y轴距离大于最小滑动距离，拦截事件，效果正常。

SV/RV：没有重写disTE方法。向上滚动，效果正常。

<br/>

2.SV+SV：有滑动冲突。

问题：内部不能滑动。

分析：外部Y轴距离大于最小滑动距离，拦截事件，导致内部不能滑动。

<br/>

解决：

**内部拦截：内部滑动时，执行getparent().reDITE(true);**
```
public class SV_SV_inner extends ScrollView {
    public SV_SV_inner(Context context) {
        super(context);
    }
    public SV_SV_inner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
```

**外部拦截：**
```
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
```

<br/>

3.SV+RV：有滑动冲突。

问题：内层在滑动时，外层也在滑动，滑动很卡顿。

分析：

SV：重写了onInterceptTouchEvent方法。当Y轴移动距离大于最小滑动距离时，就会拦截事件，否则向子View传递。

RV：没有重写dispatchTouchEvent方法。

<br/>

解决：

**内部拦截：内部滑动时，通过reDITE设置为true使事件向子View分发。**

通过打印日志会发现：当内部滑动的时候，外部没有在滑动。效果实现。

```
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
```

<br/>

4.VP+VP：没有滑动冲突。

分析：打印日志发现：外部滑动的时候内部没有滑动，内部滑动的时候外部没有滑动。

<br/>

综上，同一方向有滑动冲突的有两个例子：
* 只有一层能滑动的例子：SV+SV
* 内外层同时滑动很卡顿的例子：SV+RV

<br/>

### 不同方向：

核心点：

判断谁来拦截：根据滑动是水平滑动还是竖直滑动来判断到底由谁来拦截事件。

判断滑动方向：
* 根据滑动过程中两点之间的坐标
* 滑动路径和水平方向所形成的夹角（滑动角度）
* 水平和竖直方向距离差（距离差）（常用）
* 水平和竖直方向速度差（速度差）

滑动冲突出现的根本原因：
* 上层View拦截了下层View导致下层View无法滑动。

<br/>

1.SRL+VP：

问题：VP左下右下滑动时，SRL也在上下滑动。SRL拦截掉了VP的滑动事件。

分析：SRL源码：Y轴大于最小滑动距离时，父View拦截事件，否则不拦截。

<br/>

解决：

**内部拦截:**

SRL_VP_outer：
```
public class SRL_VP_outer extends SwipeRefreshLayout {
    public SRL_VP_outer(Context context) {
        super(context);
    }
    public SRL_VP_outer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
```

SRL_VP_inner：
```
public class SRL_VP_inner extends ViewPager {
    private float startX;
    private float startY;
    private float x;
    private float y;
    private float deltaX;
    private float deltaY;
    public SRL_VP_inner(Context context) {
        super(context);
    }
    public SRL_VP_inner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                //注释1
                ViewCompat.setNestedScrollingEnabled(this, true);
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                x = ev.getX();
                y = ev.getY();
                deltaX = Math.abs(x - startX);
                deltaY = Math.abs(y - startY);
                if (deltaX < deltaY) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
```
注释1：

* 因为SRL重写了requestDisallowInterceptTouchEvent这个方法，

* ViewCompat.isNestedScrollingEnabled(mTarget)默认为false，

* 导致super.requestDisallowInterceptTouchEvent(b)不执行，

* 所以要设置ViewCompat.isNestedScrollingEnabled为true。

</br>
**外部拦截:**

参考链接：https://blog.csdn.net/u010386612/article/details/50548977

SRL_VP_out_SRL：
```
public class SRL_VP_out_SRL extends SwipeRefreshLayout {
    private boolean mIsBeingDragged;
    private float initialX;
    private float initialY;
    private float x;
    private float y;
    private float deltaX;
    private float deltaY;
    private int mTouchSlop;
    boolean isVpDragged = false;
    public SRL_VP_out_SRL(Context context) {
        super(context);
    }
    public SRL_VP_out_SRL(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = ev.getX();
                initialY = ev.getY();
                isVpDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                //只要手指不离开就一直返回false
                if (isVpDragged)
                    return false;
                x = ev.getX();
                y = ev.getY();
                deltaX = Math.abs(x - initialX);
                deltaY = Math.abs(y - initialY);
                if (deltaX > deltaY) {
                    isVpDragged = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isVpDragged = false;
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
```
<br/>

2.SV+VP：没有冲突。

<br/>

3.VP+SV：没有冲突。

<br/>

4.VP+LV：没有冲突。


