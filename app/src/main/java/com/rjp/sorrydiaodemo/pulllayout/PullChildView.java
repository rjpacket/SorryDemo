package com.rjp.sorrydiaodemo.pulllayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * author : Gimpo create on 2018/5/2 15:43
 * email  : jimbo922@163.com
 */
public class PullChildView extends ScrollView implements JudgeScrollBottomImpl{
    public PullChildView(Context context) {
        super(context);
    }

    public PullChildView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean scrollBottom() {
        return true;
    }
}
