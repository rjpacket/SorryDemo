### 前言

昨天在写QQ空间广告图的水波纹的效果实现的时候，查了关于ImageView和Bitmap的相关知识。过程中也遇到了图片变形的问题，这个问题真是由来已久，但是一直没有很好的解决办法。

最常用的办法就是ImageView的scaleType设置为centerCrop，我感觉这个已经能解决大部分的问题，但是我还是想要一个永不拉伸的图片容器。就算图片被截断，我也要不拉伸不变形。

永不变形！！！！！！！！！

### 代码实现

1.首先我想到的是继承ImageView：
```
public class AutoFitImageView extends ImageView {

    private int width;
    private int height;
    private Paint mPaint;

    public AutoFitImageView(Context context) {
        super(context);
    }

    public AutoFitImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Drawable drawable = getDrawable();
        if(drawable != null) {
            Bitmap bitmap = zoomBitmap(drawableToBitmap(drawable), width, height);
            canvas.drawBitmap(bitmap, new Rect(bitmap.getWidth() / 2 - width / 2, bitmap.getHeight() / 2 - height / 2, bitmap.getWidth() / 2 + width / 2, bitmap.getHeight() / 2 + height / 2), new RectF(0, 0, width, height), mPaint);
        }
    }

    /**
     * drawable转bitmap  顺便拉伸
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        // 取 drawable 的长宽
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        Log.d("------>", w + " : " + h);

        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        // 建立对应 bitmap
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        // 建立对应 bitmap 的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        // 把 drawable 内容画到画布中
        drawable.draw(canvas);
        return bitmap;
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
```
注意一点，一定是使用src给ImageView设置图片源，不能使用background。

2.继承自View：
```
public class AutoFitView extends View {

    private int width;
    private int height;
    private Paint mPaint;
    private Bitmap mBitmap;

    public AutoFitView(Context context) {
        super(context);
    }

    public AutoFitView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mPaint = new Paint();

        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.top_pic);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
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
```

写法相同，不过ImageView需要创建两次临时的Bitmap，内存开销比较大。继承View更合适。

canvas.drawBitmap() 第一个Rect 代表要绘制的bitmap 区域，第二个 Rect 代表的是要将bitmap 绘制在屏幕的什么地方，这样就很容易能计算出需要绘制的区域。

我选取了一张 650*360 的图片，分别看看效果：

1.高度50dp：
![Screenshot_2018-04-20-12-38-48-074_com.rjp.sorryd.png](https://upload-images.jianshu.io/upload_images/5994029-c5ba6e7666b1c68a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


2.高度100dp：
![Screenshot_2018-04-20-12-39-57-144_com.rjp.sorryd.png](https://upload-images.jianshu.io/upload_images/5994029-e8057fffb3919aac.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


3.高度150dp：
![Screenshot_2018-04-20-12-40-24-584_com.rjp.sorryd.png](https://upload-images.jianshu.io/upload_images/5994029-4de597d8d62f5931.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


4.高度500dp：
![Screenshot_2018-04-20-12-40-59-942_com.rjp.sorryd.png](https://upload-images.jianshu.io/upload_images/5994029-560f813e59eb6efa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![Screenshot_2018-04-20-12-41-04-804_com.rjp.sorryd.png](https://upload-images.jianshu.io/upload_images/5994029-294c259ee5ad5618.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)




这里图片宽高都很小，如果是一张超大的图片呢？能经受的住考验吗？

选择的图片是一张清明上河图，立马崩溃了，java.lang.OutOfMemoryError，意料之中。但是在实际应用中，上面的方法已经是够用了。

enough is ok!

怎么加载超大的图呢？没有思路，但是已经有博客讲解了，[传送门](https://blog.csdn.net/lmj623565791/article/details/49300989/)。

本博客就是一个小demo，没有源码了


