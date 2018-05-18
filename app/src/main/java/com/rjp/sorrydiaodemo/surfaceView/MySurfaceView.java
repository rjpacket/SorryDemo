package com.rjp.sorrydiaodemo.surfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * author : Gimpo create on 2018/5/3 17:16
 * email  : jimbo922@163.com
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder mHolder;
    private boolean mIsDraw;
    private Canvas mCanvas;
    private static final int TIME_IN_FRAME = 30;
    private Path path;
    private Paint paint;

    public MySurfaceView(Context context) {
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mHolder = getHolder();
        mHolder.addCallback(this);

        path = new Path();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setPathEffect(new CornerPathEffect(10));
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDraw = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDraw = false;
    }

    @Override
    public void run() {
        while (mIsDraw) {
            /**取得更新之前的时间**/
            long startTime = System.currentTimeMillis();

            /**在这里加上线程安全锁**/
            synchronized (mHolder) {
                /**拿到当前画布 然后锁定**/
                mCanvas = mHolder.lockCanvas();
                draw();
                /**绘制结束后解锁显示在屏幕上**/
                mHolder.unlockCanvasAndPost(mCanvas);
            }

            /**取得更新结束的时间**/
            long endTime = System.currentTimeMillis();

            /**计算出一次更新的毫秒数**/
            int diffTime = (int) (endTime - startTime);

            /**确保每次更新时间为30帧**/
            while (diffTime <= TIME_IN_FRAME) {
                diffTime = (int) (System.currentTimeMillis() - startTime);
                /**线程等待**/
                Thread.yield();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return true;
    }

    private void draw() {
        mCanvas.drawColor(Color.BLACK);
        mCanvas.drawPath(path, paint);
    }
}
