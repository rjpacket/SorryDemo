package com.rjp.sorrydiaodemo.circle_image_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.rjp.sorrydiaodemo.R;

/**
 * BitmapShader 模式
 * <p>
 * 最优模式
 * author : Gimpo create on 2018/4/24 17:27
 * email  : jimbo922@163.com
 */
public class CircleImageView3 extends ImageView {
    private Context mContext;
    private int width;
    private int height;
    private Paint mPaint;
    private Xfermode SRC_ATOP = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    private Bitmap srcBitmap;
    private float bScale;

    public CircleImageView3(Context context) {
        super(context);
    }

    public CircleImageView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mContext = context;
        srcBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.top_pic);
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);

        setPaintShader(srcBitmap, mPaint);
    }

    /**
     * 设置画笔的填充
     */
    private void setPaintShader(Bitmap bitmap, Paint paint) {
        BitmapShader bShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bScale = (float) Math.max(width * 1.0 / bitmap.getWidth(), height * 1.0 / bitmap.getHeight());
        Matrix bMatrix = new Matrix();
        bMatrix.setScale(bScale, bScale);
        bShader.setLocalMatrix(bMatrix);
        paint.setShader(bShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width / 2, height / 2, width / 2, mPaint);
    }


}
