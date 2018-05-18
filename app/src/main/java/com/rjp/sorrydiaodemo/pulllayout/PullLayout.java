package com.rjp.sorrydiaodemo.pulllayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;

import com.rjp.sorrydiaodemo.R;

/**
 * author : Gimpo create on 2018/5/2 15:23
 * email  : jimbo922@163.com
 */
public class PullLayout extends LinearLayout {
    private float downX;
    private float downY;
    private JudgeScrollBottomImpl childImpl;
    private Scroller mScroller;
    private boolean isPulling;
    private int duration = 300;
    private FrameLayout layoutContainer;
    private FrameLayout bottomContainer;
    private int width;
    private int measuredHeight1;
    private int measuredHeight;

    public PullLayout(@NonNull Context context) {
        this(context, null);
    }

    public PullLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mScroller = new Scroller(context);
        LayoutInflater.from(context).inflate(R.layout.layout_pull_layout, this);

        layoutContainer = (FrameLayout) findViewById(R.id.layout_container);
        bottomContainer = (FrameLayout) findViewById(R.id.bottom_container);
    }

    public void setJudgeScrollBottomImpl(JudgeScrollBottomImpl childImpl){
        this.childImpl = childImpl;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        measuredHeight1 = layoutContainer.getMeasuredHeight();
        int measuredHeight2 = bottomContainer.getMeasuredHeight();
        measuredHeight = measuredHeight1 + measuredHeight2;
        setMeasuredDimension(width, measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        bottomContainer.layout(0, measuredHeight1, width, measuredHeight);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        float curX = ev.getX();
        float curY = ev.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = curX;
                downY = curY;
                if(!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                float dy = (float) ((curY - downY) * 0.5); //拉伸系数，越低表示越难拉动
                if(dy < 0 && childImpl.scrollBottom()){
                    scrollTo(0, (int) (getScrollY() - dy));
                    isPulling = true;
                    downY = curY;
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if(isPulling){
                    int scrollY = getScrollY();
                    mScroller.startScroll(0, scrollY, 0, -scrollY, duration);
                    isPulling = false;
                    invalidate();
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }
}
