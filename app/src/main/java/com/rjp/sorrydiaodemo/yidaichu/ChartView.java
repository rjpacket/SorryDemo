package com.rjp.sorrydiaodemo.yidaichu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

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

    private int ceilWidth = 100;
    private int ceilHeight = 100;
    private int screenWidth;
    private int screenHeight;
    private int preX;
    private int preY;
    private int viewWidth;
    private Paint linePaint;
    private Paint backgroundPaint;
    private Paint selectedPaint;

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

        backgroundPaint = new Paint();
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setColor(Color.GRAY);

        selectedPaint = new Paint();
        selectedPaint.setAntiAlias(true);
        selectedPaint.setColor(Color.RED);

        for (int i = 0; i < 20; i++) {
            CeilGroup e = new CeilGroup();
            ArrayList<Ceil> ceils = new ArrayList<>();
            for (int j = 0; j < 40; j++) {
                ceils.add(new Ceil());
            }
            e.setCeils(ceils);
            ceilGroups.add(e);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = x - preX;
                int dy = y - preY;
                scrollTo(getScrollX() - dx, getScrollY() - dy);
                computeCeilLocation(dx, dy);
                invalidate();
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(viewWidth, viewHeight);
        computeCeilLocation(0, 0);
    }

    /**
     * 计算每一个ceil的位置
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
                //左右和j相关
//                ceil.setLeft(ceilWidth * j);
//                ceil.setRight(ceilWidth * (j + 1));
                //上下和i相关
//                ceil.setTop(ceilHeight * i);
//                ceil.setBottom(ceilHeight * (i + 1));
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
            Ceil firstCeil = ceils.get(0);
            drawCeilGroupBg(canvas, firstCeil);
            int ceilSize = ceils.size();
            for (int j = 0; j < ceilSize; j++) {
                Ceil ceil = ceils.get(j);
                drawCeilTopLine(canvas, ceil);
                drawCeilLeftLine(canvas, ceil);
                drawCeilBackground(canvas, ceil);
                drawCeilLinkLine(canvas, j);
                drawCeilSelected(canvas, ceil);
                drawCeilText(canvas, j);
            }
        }
    }

    /**
     * 设置ceil选中的效果
     * @param canvas
     * @param ceil
     */
    private void drawCeilSelected(Canvas canvas, Ceil ceil) {
        canvas.drawOval(new RectF(ceil.getLeft(), ceil.getTop(), ceil.getRight(), ceil.getTop()),  linePaint);
    }

    /**
     * 绘制ceil顶部的分割线
     * @param canvas
     * @param ceil
     */
    private void drawCeilTopLine(Canvas canvas, Ceil ceil) {
        canvas.drawLine(ceil.getLeft(), ceil.getTop(), ceil.getRight(), ceil.getTop(), linePaint);
    }

    /**
     * 绘制ceil的连线
     *
     *  @param canvas
     *  @param j
     */
    private void drawCeilLinkLine(Canvas canvas, int j) {

    }

    /**
     * 绘制ceil的文字
     *
     *  @param canvas
     *  @param j
     */
    private void drawCeilText(Canvas canvas, int j) {

    }

    /**
     * 绘制ceil的背景
     *
     *  @param canvas
     *  @param ceil
     */
    private void drawCeilBackground(Canvas canvas, Ceil ceil) {
        canvas.drawRect(ceil.getLeft(), ceil.getTop(), ceil.getLeft(), ceil.getBottom(), backgroundPaint);
    }

    /**
     * 绘制ceil左边的分割线
     *  @param canvas
     *  @param ceil
     */
    private void drawCeilLeftLine(Canvas canvas, Ceil ceil) {
        canvas.drawLine(ceil.getLeft(), ceil.getTop(), ceil.getLeft(), ceil.getBottom(), linePaint);
    }

    /**
     * 绘制长背景
     *  @param canvas
     *  @param i
     */
    private void drawCeilGroupBg(Canvas canvas, Ceil i) {

    }

    /**
     * 绘制一根分割线
     *  @param canvas
     *  @param firstCeil
     */
    private void drawTopLine(Canvas canvas, Ceil firstCeil) {
        canvas.drawLine(firstCeil.getLeft(), firstCeil.getTop(), viewWidth, firstCeil.getTop(), linePaint);
    }
}
