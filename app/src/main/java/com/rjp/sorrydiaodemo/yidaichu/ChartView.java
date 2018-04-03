package com.rjp.sorrydiaodemo.yidaichu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 越界的表格View
 * author : Gimpo create on 2018/4/2 16:29
 * email  : jimbo922@163.com
 */

public class ChartView extends View {

    public static final int MODE_EQUAL = 1;
    public static final int MODE_APPEND = 2;

    public int mode = MODE_APPEND;
    private List<CeilGroup> ceilGroups = new ArrayList<>();
    private List<Ceil> selectedCeils = new ArrayList<>();

    private int ceilWidth = 100;
    private int ceilHeight = 100;
    private int screenWidth;
    private int screenHeight;
    private int preX;
    private int preY;
    private Paint linePaint;
    private Paint backgroundPaint;
    private Paint selectedPaint;
    private Paint linkLinePaint;
    private Paint textPaint;
    private int viewWidth;
    private int viewHeight;

    private int maxWidth;
    private int maxHeight;
    private Scroller mScroller;
    private int mMinimumVelocity;
    private int mMaximumVelocity;
    private VelocityTracker mVelocityTracker;

    public ChartView(Context context) {
        this(context, null);
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        screenHeight = context.getResources().getDisplayMetrics().heightPixels;

        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.BLACK);

        linkLinePaint = new Paint();
        linkLinePaint.setAntiAlias(true);
        linkLinePaint.setStrokeWidth(4);
        linkLinePaint.setColor(Color.RED);
        linkLinePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));

        backgroundPaint = new Paint();
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setColor(Color.GRAY);

        selectedPaint = new Paint();
        selectedPaint.setAntiAlias(true);
        selectedPaint.setColor(Color.RED);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(32);
        linkLinePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));

        // 新增部分 start
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        mScroller = new Scroller(context);
        mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();

        Ceil preCeil = null;
        Random random = new Random();
        for (int i = 0; i < 300; i++) {
            CeilGroup e = new CeilGroup();
            ArrayList<Ceil> ceils = new ArrayList<>();
            int selectedIndex = random.nextInt(30);
            for (int j = 0; j < 40; j++) {
                Ceil e1 = new Ceil();
                e1.setNumber(String.valueOf(j));
                if (j == selectedIndex) {
                    e1.setSelected(true);
                }
                ceils.add(e1);
                if (preCeil != null && e1.isSelected()) {
                    e1.setNextCeil(i == 0 ? null : preCeil);
                }
                if (e1.isSelected()) {
                    preCeil = e1;
                }
            }
            e.setCeils(ceils);
            ceilGroups.add(e);
        }
        maxWidth = 40 * ceilWidth;
        maxHeight = 300 * ceilHeight;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        obtainVelocityTracker();
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = x - preX;
                int dy = y - preY;
                scrollTo(getScrollX() - dx, getScrollY() - dy);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mVelocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                int initialVelocityX = (int) mVelocityTracker.getXVelocity();
                int initialVelocityY = (int) mVelocityTracker.getYVelocity();
                if ((Math.abs(initialVelocityX) > mMinimumVelocity) || (Math.abs(initialVelocityY) > mMinimumVelocity)) {
                    flingXY(-initialVelocityX, -initialVelocityY);
                }
                releaseVelocityTracker();
                break;
        }
        if (mVelocityTracker != null) {
            mVelocityTracker.addMovement(event);
        }
        return true;
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            scrollTo(x, y);
        }
    }

    /**
     * 惯性滑动
     *
     * @param velocityX
     * @param velocaityY
     */
    public void flingXY(int velocityX, int velocaityY) {
        mScroller.fling(getScrollX(), getScrollY(), velocityX, velocaityY, 0, maxWidth - viewWidth, 0, maxHeight - viewHeight);
    }

    /**
     * 初始化 速度追踪器
     */
    private void obtainVelocityTracker() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    /**
     * 释放 速度追踪器
     */
    private void releaseVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {
        if (x < 0) {
            x = 0;
        }
        if (x > maxWidth - viewWidth) {
            x = maxWidth - viewWidth;
        }
        if (y < 0) {
            y = 0;
        }
        if (y > maxHeight - viewHeight) {
            y = maxHeight - viewHeight;
        }
        super.scrollTo(x, y);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(viewWidth, viewHeight);
        computeCeilLocation(0, 0);
    }

    /**
     * 计算每一个ceil的位置
     *
     * @param dx
     * @param dy
     */
    private void computeCeilLocation(int dx, int dy) {
        int groupSize = ceilGroups.size();
        for (int i = 0; i < groupSize; i++) {
            CeilGroup ceilGroup = ceilGroups.get(i);
            List<Ceil> ceils = ceilGroup.getCeils();
            int ceilSize = ceils.size();
            for (int j = 0; j < ceilSize; j++) {
                Ceil ceil = ceils.get(j);
                ceil.setLocation(ceilWidth * j + dx, ceilWidth * (j + 1) + dx, ceilHeight * i + dy, ceilHeight * (i + 1) + dy);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int groupSize = ceilGroups.size();
        for (int i = 0; i < groupSize; i++) {
            CeilGroup ceilGroup = ceilGroups.get(i);
            List<Ceil> ceils = ceilGroup.getCeils();
            int ceilSize = ceils.size();
            for (int j = 0; j < ceilSize; j++) {
                Ceil ceil = ceils.get(j);
                if (isCeilVisiable(ceil)) {
                    drawCeilTopLine(canvas, ceil);
                    drawCeilLeftLine(canvas, ceil);
                    drawCeilBackground(canvas, ceil);
                }
            }
        }

        for (int i = 0; i < groupSize; i++) {
            CeilGroup ceilGroup = ceilGroups.get(i);
            List<Ceil> ceils = ceilGroup.getCeils();
            int ceilSize = ceils.size();
            for (int j = 0; j < ceilSize; j++) {
                Ceil ceil = ceils.get(j);
                drawCeilLinkLine(canvas, ceil);
            }
        }

        for (int i = 0; i < groupSize; i++) {
            CeilGroup ceilGroup = ceilGroups.get(i);
            List<Ceil> ceils = ceilGroup.getCeils();
            int ceilSize = ceils.size();
            for (int j = 0; j < ceilSize; j++) {
                Ceil ceil = ceils.get(j);
                if (isCeilVisiable(ceil)) {
                    drawCeilSelected(canvas, ceil);
                    drawCeilText(canvas, ceil);
                }
            }
        }
    }

    /**
     * 判断ceil是否可见
     *
     * @param ceil
     * @return
     */
    private boolean isCeilVisiable(Ceil ceil) {
        return ceil.getRight() > getScrollX() && ceil.getBottom() > getScrollY() && ceil.getLeft() < viewWidth + getScrollX() && ceil.getTop() < viewHeight + getScrollY();
    }

    /**
     * 绘制ceil的文字
     *
     * @param canvas
     * @param ceil
     */
    private void drawCeilText(Canvas canvas, Ceil ceil) {
        textPaint.setColor(ceil.isSelected() ? Color.WHITE : Color.BLACK);
        canvas.drawText(ceil.getNumber(), ceil.getCenterX(), ceil.getCenterY(), textPaint);
    }

    /**
     * 设置ceil选中的效果
     *
     * @param canvas
     * @param ceil
     */
    private void drawCeilSelected(Canvas canvas, Ceil ceil) {
        if (ceil.isSelected()) {
            canvas.drawOval(new RectF(ceil.getLeft(), ceil.getTop(), ceil.getRight(), ceil.getBottom()), selectedPaint);
        }
    }

    /**
     * 绘制ceil的背景
     *
     * @param canvas
     * @param ceil
     */
    private void drawCeilBackground(Canvas canvas, Ceil ceil) {
        canvas.drawRect(ceil.getLeft(), ceil.getTop(), ceil.getRight(), ceil.getBottom(), backgroundPaint);
    }

    /**
     * 绘制ceil的连线
     *
     * @param canvas
     * @param ceil
     */
    private void drawCeilLinkLine(Canvas canvas, Ceil ceil) {
        Ceil nextCeil = ceil.getNextCeil();
        if (nextCeil != null) {
            canvas.drawLine(nextCeil.getCenterX(), nextCeil.getCenterY(), ceil.getCenterX(), ceil.getCenterY(), linkLinePaint);
        }
    }

    /**
     * 绘制ceil左边的分割线
     *
     * @param canvas
     * @param ceil
     */
    private void drawCeilLeftLine(Canvas canvas, Ceil ceil) {
        canvas.drawLine(ceil.getLeft(), ceil.getTop(), ceil.getLeft(), ceil.getBottom(), linePaint);
    }

    /**
     * 绘制ceil顶部的分割线
     *
     * @param canvas
     * @param ceil
     */
    private void drawCeilTopLine(Canvas canvas, Ceil ceil) {
        canvas.drawLine(ceil.getLeft(), ceil.getTop(), ceil.getRight(), ceil.getTop(), linePaint);
    }
}
