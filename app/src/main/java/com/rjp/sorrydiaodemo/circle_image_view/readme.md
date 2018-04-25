### 第一种圆形图片的实现

```
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
```
圆形图片第一种实现是生成一张圆形的图片，然后直接绘制在bitmap上。绘制bitmap是可以选择区域的，
```
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
```
第一个rect参数就是选中的图片的区域。
然后设置canvas DST_IN 模式，再把一个圆形的src层绘制上去。如果不new Canvas() 绘制bitmap，setLayer也是可以的，下面就是这种方式。

### 第二种圆形图片的实现
```
/**
 * SRC_ATOP 模式
 * <p>
 * 缺点：需要生成两张临时的缩放图片
 * author : Gimpo create on 2018/4/24 17:27
 * email  : jimbo922@163.com
 */
public class CircleImageView2 extends ImageView {
    private Context mContext;
    private int width;
    private int height;
    private Bitmap srcBitmap;
    private Paint mPaint;
    private Xfermode SRC_ATOP = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    private Bitmap targetBitmap;
    private Bitmap dstBitmap;
    private Rect srcRect;
    private RectF dstRect;

    public CircleImageView2(Context context) {
        super(context);
    }

    public CircleImageView2(Context context, @Nullable AttributeSet attrs) {
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
        dstBitmap = getBitmap();
        targetBitmap = zoomBitmap(srcBitmap, width, height);
        if(srcRect == null) {
            srcRect = new Rect(targetBitmap.getWidth() / 2 - width / 2, targetBitmap.getHeight() / 2 - height / 2, targetBitmap.getWidth() / 2 + width / 2, targetBitmap.getHeight() / 2 + height / 2);
            dstRect = new RectF(0, 0, width, height);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sc = canvas.saveLayer(0, 0, width, height, mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, 0, 0, mPaint);
        mPaint.setXfermode(SRC_ATOP);
        canvas.drawBitmap(targetBitmap, srcRect, dstRect, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(sc);
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
```
不同于第一种，这种绘制是首先绘制圆形的边界dst，再绘制src源图片。由于是直接setLayer 离屏绘制，所以比较第一种少生成一个临时的bitmap变量，比前一种优化点。

### 第三种圆形图片的实现
```
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
```
借助 BitmapShader 这个类，代码非常简洁。不需要生成一张压缩或者拉伸的图片，直接借助矩阵变换。没有额外的内存开销，所以是最优化的，但是有一个缺点，就是当图片长度或者高度远远超出ImageView的高度的时候，会只绘制图片初始的位置，不是居中显示的。

可以看一下三种效果图：


如果是上传头像这种，可以事先裁剪成正方形的头像，再使用第三种圆形头像的方法，非常合适。



