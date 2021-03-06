package com.rjp.sorrydiaodemo.circle_image_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.rjp.sorrydiaodemo.R;

/**
 * DST_IN 模式
 * <p>
 * 缺点：需要生成三张临时的缩放图片
 * author : Gimpo create on 2018/4/24 17:27
 * email  : jimbo922@163.com
 */
public class CircleImageView1 extends ImageView {
    private Context mContext;
    private int width;
    private int height;
    private Bitmap srcBitmap;
    private Paint mPaint;
    private Xfermode DST_IN = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Bitmap targetBitmap;

    public CircleImageView1(Context context) {
        super(context);
    }

    public CircleImageView1(Context context, @Nullable AttributeSet attrs) {
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
        targetBitmap = dealBitmap(zoomBitmap(srcBitmap, width, height));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(targetBitmap, 0, 0, mPaint);
    }

    /**
     * 处理 bitmap
     *
     * @param bitmap
     * @return
     */
    public Bitmap dealBitmap(Bitmap bitmap) {
        Bitmap temp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(temp);
        canvas.drawBitmap(bitmap,
                new Rect(bitmap.getWidth() / 2 - width / 2,
                        bitmap.getHeight() / 2 - height / 2,
                        bitmap.getWidth() / 2 + width / 2,
                        bitmap.getHeight() / 2 + height / 2),
                new RectF(0,
                        0,
                        width,
                        height),
                mPaint);
        Bitmap dst = getBitmap();
        mPaint.setXfermode(DST_IN);
        canvas.drawBitmap(dst, 0, 0, mPaint);
        mPaint.setXfermode(null);
        return temp;
    }

    /**
     * 绘制形状
     *
     * @return
     */
    public Bitmap getBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(width / 2, height / 2, width / 2, paint);
        return bitmap;
    }

    /**
     * 放大图片   会生成新的图片，资源浪费
     *
     * @param bm
     * @param newWidth
     * @param newHeight
     * @return
     */
    public static Bitmap zoomBitmap(Bitmap bm, int newWidth, int newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        float maxScale = Math.max(scaleWidth, scaleHeight);
        matrix.postScale(maxScale, maxScale);
        // 得到新的图片
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }
}
