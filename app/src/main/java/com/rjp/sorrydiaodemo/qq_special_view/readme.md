### 前言

最近刷qq空间动态的时候，有一个广告的效果很有意思，ImageView的水波纹效果，上下两层ImageViewA和ImageViewB，下滑的时候ImageViewA水波纹扩大，一直到移出手机屏幕，再上滑的时候，ImageViewB做水波纹的效果。

效果很有意思，代码实现起来也是很简单。首先看下效果：





### 代码实现
```
public class BeautView extends View {
    private Bitmap topBitmap;
    private Bitmap bottomBitmap;
    private Paint topPaint;
    private Paint bottomPaint;
    private int width;
    private int height;
    //锚点
    private Point povit = new Point();
    private Context mContext;
    private int radius;
    private PorterDuffXfermode mXfermode;
    public static final int MODE_UP = 1;
    public static final int MODE_DOWN = 2;
    private int mode = MODE_DOWN;

    public BeautView(Context context) {
        super(context);
    }

    public BeautView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mContext = context;

        topBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.top_pic);
        bottomBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.bottom_pic);

        topPaint = new Paint();
        bottomPaint = new Paint();

        //src_over 模式
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);

        //首先缩放bitmap，完全填满View的空间
        topBitmap = zoomBitmap(topBitmap, width, height);
        bottomBitmap = zoomBitmap(bottomBitmap, width, height);
        //填充画笔
        setPaintShader(topBitmap, topPaint);
        setPaintShader(bottomBitmap, bottomPaint);
    }

    /**
     * 设置画笔的填充
     */
    private void setPaintShader(Bitmap bitmap, Paint paint) {
        BitmapShader bShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        float bScale = (float) Math.max(width * 1.0 / bitmap.getWidth(), height * 1.0 / bitmap.getHeight());
        Matrix bMatrix = new Matrix();
        bMatrix.setScale(bScale, bScale);
        bShader.setLocalMatrix(bMatrix);
        paint.setShader(bShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int sc = canvas.saveLayer(0, 0, width, height, null, Canvas.ALL_SAVE_FLAG);
        //画笔填充了bitmap，绘制的时候只要写出绘制的区域dst就好
        canvas.drawRect(0, 0, width, height, bottomPaint);
        topPaint.setXfermode(mXfermode);
        //绘制圆src区域
        canvas.drawCircle(povit.x, povit.y, radius,  topPaint);
        topPaint.setXfermode(null);
        canvas.restoreToCount(sc);
    }

    public int getHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public int getWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
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

    /**
     * 计算view距顶top的时候radius的大小
     * @param top
     */
    public void setBitmapTop(int top) {
        if (top > 100) {
            povit.x = 0;
            povit.y = 0;
            radius = top - 100;
        } else {
            radius = 0;
        }
        invalidate();
    }

    /**
     * 计算距底bottom的时候radius的大小
     * @param bottom
     */
    public void setBitmapBottom(int bottom) {
        int screenHeight = getHeight(mContext);
        if(bottom < screenHeight - 100) {
            povit.x = width;
            povit.y = height;
            radius = screenHeight - 100 - bottom;
        } else {
            radius = 0;
        }
        invalidate();
    }

    public int getMode() {
        return mode;
    }

    /**
     * 设置mode  实际也是改变mode
     * 改变mode的时候需要交换画笔，也就是交换了bitmap绘制顺序，上面的bitmap去下面了，下面的上来了
     * @param mode
     */
    public void setMode(int mode) {
        this.mode = mode;
        Paint temp = topPaint;
        topPaint = bottomPaint;
        bottomPaint = temp;
    }
}
```
注释已经写的很清楚了，重要的就是弄清楚 PorterDuff.Mode 这个类下面参数的代表意义，大致就是图片的并集交集，可以搜索了解一下。

实际上你绘制两张重叠的bitmap也能实现功能，但是肯定是存在过度绘制的问题。

### 使用
因为是自定义的View，没办法自动监听滑动事件，需要借助ScrollView或者ListView，这里使用的是ScrollView，ListView原理相同：
```
    scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
        @Override
        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            int mode = beautView.getMode();
            if (mode == BeautView.MODE_UP) {
                int bottom = beautView.getBottom() - scrollY;
                beautView.setBitmapBottom(bottom);
                if(bottom < 0){
                    beautView.setMode(BeautView.MODE_DOWN);
                }
            }
            if (mode == BeautView.MODE_DOWN) {
                int top = beautView.getTop() - scrollY;
                beautView.setBitmapTop(top);
                if(top > getHeight(mContext)){
                    beautView.setMode(BeautView.MODE_UP);
                }
            }
        }
    });
```
首先获取 View 当前的 mode ，如果MODE_UP，上行，就设置下面的水波纹扩散，反过来设置上面的水波纹扩散。如果bottom小于0说明View从手机上面滑出界面了，这个时候改变mode，同理，如果top大于手机屏幕高度，说明View从手机下面滑出去了，这个时候也要改变mode。

从而达到一种无缝的过渡，用户不会明显看出纰漏。

小demo，不上源码了。

喜欢给个赞，3q。


