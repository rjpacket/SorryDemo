package com.rjp.sorrydiaodemo.gift;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.rjp.sorrydiaodemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Gimpo create on 2018/3/30 15:30
 * email  : jimbo922@163.com
 */

public class GiftView extends FrameLayout {

    private Context mContext;

    private List<GiftModel> giftModels = new ArrayList<>();

    public GiftView(Context context) {
        this(context, null);
    }

    public GiftView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getRawX();
        float y = event.getRawY();

        for (int i = 0; i < 1; i++) {
            int resId = 0;
            switch (i % 6) {
                case 0:
                    resId = R.mipmap.bg_open_one;
                    break;
                case 1:
                    resId = R.mipmap.bg_open_two;
                    break;
                case 2:
                    resId = R.mipmap.bg_open_three;
                    break;
                case 3:
                    resId = R.mipmap.bg_open_four;
                    break;
                case 4:
                    resId = R.mipmap.bg_open_five;
                    break;
                case 5:
                    resId = R.mipmap.bg_open_six;
                    break;
            }
            addView(new GiftModel(mContext, resId, new PointF(x, y)));
        }
        return super.onTouchEvent(event);
    }
}
