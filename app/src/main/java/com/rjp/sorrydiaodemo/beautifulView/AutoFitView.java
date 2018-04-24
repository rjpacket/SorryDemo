package com.rjp.sorrydiaodemo.beautifulView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.rjp.sorrydiaodemo.R;

import java.io.InputStream;

/**
 * 自动适应 ImageView
 * author : Gimpo create on 2018/4/20 11:15
 * email  : jimbo922@163.com
 */
public class AutoFitView extends View {

    private int width;
    private int height;
    private Paint mPaint;
    private Bitmap mBitmap;
    private Context mContext;

    public AutoFitView(Context context) {
        super(context);
    }

    public AutoFitView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mContext = context;
        mPaint = new Paint();

        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.big_01);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
//        loadBitmap();
    }

    private void loadBitmap() {
        try {
            InputStream inputStream = mContext.getAssets().open("qm.jpg");

            //获得图片的宽、高
            BitmapFactory.Options tmpOptions = new BitmapFactory.Options();
            tmpOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, tmpOptions);
            int w = tmpOptions.outWidth;
            int h = tmpOptions.outHeight;

            //设置显示图片的中心区域
            BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            mBitmap = bitmapRegionDecoder.decodeRegion(new Rect(w / 2 - width / 2, h / 2 - height / 2, w / 2 + width / 2, h / 2 + height / 2), options);
        }catch (Exception e){

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mBitmap != null) {
            Bitmap bitmap = zoomBitmap(mBitmap, width, height);
            canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() / 2 - width / 2, bitmap.getHeight() / 2 - height / 2, bitmap.getWidth() / 2 + width / 2, bitmap.getHeight() / 2 + height / 2), new RectF(0, 0, width, height), mPaint);
        }
    }

    /**
     * 对一张图片进行拉伸
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
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }
}
