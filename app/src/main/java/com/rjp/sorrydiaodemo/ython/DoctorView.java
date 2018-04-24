package com.rjp.sorrydiaodemo.ython;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author : Gimpo create on 2018/4/9 17:22
 * email  : jimbo922@163.com
 */

public class DoctorView extends View {

    //每一行代表的数值大小
    public static final int LINE_NUMBER = 1000;
    //最大显示几行
    public static final int MAX_LINE_COUNT = 8;
    //四个数据模型
    private List<LeftModel> leftModels;
    private List<BottomModel> bottomModels;
    private List<StandardModel> standardModels;     //基准线
    private List<DataModel> dataModels;             //数据
    //view 宽度
    private int viewWidth;
    private int viewHeight;
    private int maxWidth;
    private int maxHeight;
    //行宽  行高
    private int lineHeight = 200;
    private int lineWidth = 200;

    //左右偏移的宽度
    private int leftOffset = 200;
    private int bottomOffset = 200;

    private int lineCount; //行数
    private Paint virtualPaint;
    private Paint bottomPaint;
    private Path virtualPath;
    private Paint standardPaint;
    private Paint dataPaint;
    private Path shaderPath;
    private Paint shaderPaint;
    private int downX;
    private int downY;
    private Paint whitePaint;
    private Paint circlePaint;
    private Paint leftTitlePaint;

    public DoctorView(Context context) {
        this(context, null);
    }

    public DoctorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        leftModels = new ArrayList<>();
        for (int i = 0; i < 39; i++) {
            leftModels.add(new LeftModel(String.valueOf(i * LINE_NUMBER)));
        }

        bottomModels = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            bottomModels.add(new BottomModel(String.valueOf(i)));
        }

        standardModels = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            standardModels.add(new StandardModel(i * 1300));
        }

        dataModels = new ArrayList<>();
        Random random = new Random();
        dataModels.add(new DataModel(0));
        dataModels.add(new DataModel(1200));
        dataModels.add(new DataModel(1500));
        dataModels.add(new DataModel(3000));
        dataModels.add(new DataModel(4200));
        dataModels.add(new DataModel(6700));
        dataModels.add(new DataModel(1200));
        dataModels.add(new DataModel(1500));
        dataModels.add(new DataModel(3000));
        dataModels.add(new DataModel(4200));
        dataModels.add(new DataModel(6700));
        dataModels.add(new DataModel(1200));
        dataModels.add(new DataModel(1500));
        dataModels.add(new DataModel(3000));
        dataModels.add(new DataModel(4200));
        dataModels.add(new DataModel(6700));
        dataModels.add(new DataModel(1200));
        dataModels.add(new DataModel(1500));
        dataModels.add(new DataModel(3000));
        dataModels.add(new DataModel(4200));
        dataModels.add(new DataModel(6700));
        dataModels.add(new DataModel(1200));
        dataModels.add(new DataModel(1500));
        dataModels.add(new DataModel(3000));
        dataModels.add(new DataModel(4200));
        dataModels.add(new DataModel(6700));
        dataModels.add(new DataModel(1200));
        dataModels.add(new DataModel(1500));
        dataModels.add(new DataModel(3000));
        dataModels.add(new DataModel(4200));
        dataModels.add(new DataModel(300));

        virtualPaint = new Paint();
        virtualPaint.setAntiAlias(true);
        virtualPaint.setColor(Color.parseColor("#999999"));
        virtualPaint.setStyle(Paint.Style.STROKE);
        virtualPaint.setStrokeWidth(4);
        virtualPaint.setPathEffect(new DashPathEffect(new float[]{4, 4}, 0));
        virtualPath = new Path();

        leftTitlePaint = new Paint();
        leftTitlePaint.setTextAlign(Paint.Align.CENTER);
        leftTitlePaint.setTextSize(40);
        leftTitlePaint.setColor(Color.BLACK);

        bottomPaint = new Paint();
        bottomPaint.setAntiAlias(true);
        bottomPaint.setColor(Color.parseColor("#333333"));

        standardPaint = new Paint();
        standardPaint.setAntiAlias(true);
        standardPaint.setStrokeWidth(4);
        standardPaint.setColor(Color.parseColor("#d36458"));

        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setStrokeWidth(4);
        whitePaint.setColor(Color.WHITE);

        dataPaint = new Paint();
        dataPaint.setAntiAlias(true);
        dataPaint.setStrokeWidth(4);
        dataPaint.setColor(Color.parseColor("#303F9F"));

//        SweepGradient mSweepGradient = new SweepGradient(
//                viewWidth / 2,
//                viewHeight / 2, //以圆弧中心作为扫描渲染的中心以便实现需要的效果
//                new int[]{Color.parseColor("#88303F9F"), Color.parseColor("#22303F9F")}, //这是我定义好的颜色数组，包含2个颜色：#35C3D7、#2894DD
//                null);
        shaderPaint = new Paint();
        shaderPaint.setAntiAlias(true);
        shaderPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        shaderPath = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        //限制一下高度
        lineCount = leftModels.size() > MAX_LINE_COUNT ? MAX_LINE_COUNT : leftModels.size();
        viewHeight = lineCount * lineHeight;
        setMeasuredDimension(viewWidth, viewHeight);
        //计算最大可滑动的距离
        maxWidth = lineWidth * bottomModels.size();
        maxHeight = lineHeight * leftModels.size();
        computeAllLocation();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int curX = (int) event.getX();
        int curY = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = curX;
                downY = curY;
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = curX - downX;
                int dy = curY - downY;
                scrollTo(getScrollX() - dx, getScrollY() - dy);
                downX = curX;
                downY = curY;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {
        if (x < 0) {
            x = 0;
        }
        if (x > maxWidth - viewWidth) {
            x = maxWidth - viewWidth;
        }
        if(y > 0){
            y = 0;
        }
        if(y < viewHeight - maxHeight){
            y = viewHeight - maxHeight;
        }
        super.scrollTo(x, y);
    }

    /**
     * 计算所有的位置信息   x 轴计算全部加上 offset  y 轴则需要减去 offset
     */
    private void computeAllLocation() {
        //计算左边坐标
        int leftSize = leftModels.size();
        for (int i = 0; i < leftSize; i++) {
            LeftModel leftModel = leftModels.get(i);
            leftModel.setLocation(leftOffset, viewHeight - i * lineHeight - bottomOffset, viewWidth, viewHeight - i * lineHeight - bottomOffset);
            leftModel.setRect(0, leftModel.getY0() - lineHeight / 2, leftOffset, leftModel.getY0() + lineHeight / 2);
        }

        //计算底部左边
        int bottomSize = bottomModels.size();
        for (int i = 0; i < bottomSize; i++) {
            BottomModel bottomModel = bottomModels.get(i);
            bottomModel.setBx(i * lineWidth + leftOffset);
            bottomModel.setBy(viewHeight - bottomOffset);
            bottomModel.setRect(bottomModel.getBx() - lineWidth / 2, viewHeight - bottomOffset, bottomModel.getBx() + lineWidth / 2, viewHeight);
        }

        //计算黄线坐标
        int ySize = standardModels.size();
        for (int i = 0; i < ySize; i++) {
            StandardModel standardModel = standardModels.get(i);
            standardModel.setLocation(i * lineWidth + leftOffset, (lineHeight * lineCount * LINE_NUMBER - lineHeight * standardModel.getNumber()) / LINE_NUMBER - bottomOffset);
        }

        //计算数据线坐标
        int dSize = dataModels.size();
        for (int i = 0; i < dSize; i++) {
            DataModel dataModel = dataModels.get(i);
            dataModel.setLocation(i * lineWidth + leftOffset, (lineHeight * lineCount * LINE_NUMBER - lineHeight * dataModel.getNumber()) / LINE_NUMBER - bottomOffset);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawStandardLine(canvas);
        drawDataLine(canvas);
        drawBottomLine(canvas);
        drawVirtualLine(canvas);
        drawBottomTitle(canvas);
        //绘制左下角的白块
        canvas.drawRect(getScrollX(), viewHeight - bottomOffset + getScrollY(), leftOffset + getScrollX(), viewHeight + getScrollY(), whitePaint);
    }

    /**
     * 绘制底部的标题等
     * @param canvas
     */
    private void drawBottomTitle(Canvas canvas) {
        int size = bottomModels.size();
        for (int i = 0; i < size; i++) {
            BottomModel startB = bottomModels.get(i);
            if(isBottomTitleVisiable(startB)) {
                canvas.drawRect(startB.getLeft(), startB.getTop() + getScrollY(), startB.getRight(), startB.getBottom() + getScrollY(), whitePaint);
                canvas.drawText(startB.getTitle(), startB.getMidX(), startB.getMidY() + getScrollY(), leftTitlePaint);
            }
        }
    }

    private boolean isBottomTitleVisiable(BottomModel startB) {
        return startB.getBx() > getScrollX() && startB.getBx() - lineWidth < viewWidth + getScrollX();
    }

    /**
     * 绘制数据线
     *
     * @param canvas
     */
    private void drawDataLine(Canvas canvas) {
        shaderPath.moveTo(leftOffset, viewHeight - bottomOffset);
        int size = dataModels.size();
        for (int i = 0; i < size - 1; i++) {
            DataModel startD = dataModels.get(i);
            DataModel endD = dataModels.get(i + 1);
            if(isDataLineVisiable(startD, endD)) {
                shaderPath.lineTo(startD.getDx(), startD.getDy());
                shaderPath.lineTo(endD.getDx(), endD.getDy());
                canvas.drawLine(startD.getDx(), startD.getDy(), endD.getDx(), endD.getDy(), dataPaint);
                canvas.drawCircle(startD.getDx(), startD.getDy(), 8, dataPaint);
                canvas.drawCircle(endD.getDx(), endD.getDy(), 8, dataPaint);
            }
        }
        shaderPath.lineTo(viewWidth + getScrollX(), viewHeight - bottomOffset);
        shaderPath.lineTo(leftOffset, viewHeight - bottomOffset);
        //线性渐变
        LinearGradient linearGradient = new LinearGradient(0, 0, 0, viewHeight, new int[]{Color.parseColor("#303F9F"), Color.parseColor("#22303F9F")}, null, Shader.TileMode.CLAMP);
        shaderPaint.setShader(linearGradient);
        canvas.drawPath(shaderPath, shaderPaint);
        shaderPath.reset();
    }

    /**
     * 数据线在可视范围内
     * @param startD
     * @param endD
     * @return
     */
    private boolean isDataLineVisiable(DataModel startD, DataModel endD) {
        return startD.getDx() + lineWidth > getScrollX() && endD.getDx() - lineWidth < getScrollX() + viewWidth;
    }

    /**
     * 绘制黄线
     *
     * @param canvas
     */
    private void drawStandardLine(Canvas canvas) {
        int size = standardModels.size();
        for (int i = 0; i < size - 1; i++) {
            StandardModel startS = standardModels.get(i);
            StandardModel endS = standardModels.get(i + 1);
            if(isStandardLineVisiable(startS, endS)) {
                canvas.drawLine(startS.getSx(), startS.getSy(), endS.getSx(), endS.getSy(), standardPaint);
                canvas.drawCircle(startS.getSx(), startS.getSy(), 12, standardPaint);
                canvas.drawCircle(startS.getSx(), startS.getSy(), 8, whitePaint);

                canvas.drawCircle(endS.getSx(), endS.getSy(), 12, standardPaint);
                canvas.drawCircle(endS.getSx(), endS.getSy(), 8, whitePaint);
            }
        }
    }

    /**
     * 标准线在可视范围
     * @param startS
     * @param endS
     * @return
     */
    private boolean isStandardLineVisiable(StandardModel startS, StandardModel endS) {
        return startS.getSx() + lineWidth > getScrollX() && endS.getSx() - lineWidth < getScrollX() + viewWidth;
    }

    /**
     * 绘制底部的横轴
     *
     * @param canvas
     */
    private void drawBottomLine(Canvas canvas) {
        int size = bottomModels.size();
        for (int i = 0; i < size - 1; i++) {
            BottomModel startB = bottomModels.get(i);
            BottomModel endB = bottomModels.get(i + 1);
            if(isBottomLineVisiable(startB, endB)) {
                canvas.drawLine(startB.getBx(), startB.getBy() + getScrollY(), endB.getBx(), endB.getBy() + getScrollY(), bottomPaint);

//                canvas.drawRect(startB.getLeft(), startB.getTop() + getScrollY(), startB.getRight(), startB.getBottom() + getScrollY(), whitePaint);
//                canvas.drawText(startB.getTitle(), startB.getMidX(), startB.getMidY() + getScrollY(), leftTitlePaint);
            }
        }
    }

    /**
     * 判断底部栏是不是在可视范围
     * 减2个linewidth是为了多绘制一个底部rect
     * @param startB
     * @param endB
     * @return
     */
    private boolean isBottomLineVisiable(BottomModel startB, BottomModel endB) {
        return startB.getBx() + lineWidth > getScrollX() && endB.getBx() - lineWidth - lineWidth < getScrollX() + viewWidth;
    }

    /**
     * 绘制虚线
     *
     * @param canvas
     */
    private void drawVirtualLine(Canvas canvas) {
        int size = leftModels.size();
        //虚线从第一条开始绘制
        for (int i = 0; i < size; i++) {
            LeftModel leftModel = leftModels.get(i);
            if(isVirtualLineVisiable(leftModel)) {
                if(i != 0) {
                    virtualPath.moveTo(leftModel.getX0() + getScrollX(), leftModel.getY0());
                    virtualPath.lineTo(leftModel.getX1() + getScrollX(), leftModel.getY1());
                    canvas.drawPath(virtualPath, virtualPaint);
                    virtualPath.reset();
                }
                canvas.drawRect(leftModel.getLeft() + getScrollX(), leftModel.getTop(), leftModel.getRight() + getScrollX(), leftModel.getBottom(), whitePaint);
                canvas.drawText(leftModel.getTitle(), leftModel.getMidX() + getScrollX(), leftModel.getMidY(), leftTitlePaint);
            }
        }
    }

    /**
     * 左边多加一个lineHeight 也是为了多绘制一个左边rect
     * @param leftModel
     * @return
     */
    private boolean isVirtualLineVisiable(LeftModel leftModel) {
        return leftModel.getY0() + lineHeight > getScrollY() && leftModel.getY0() < viewHeight + getScrollY();
    }
}
