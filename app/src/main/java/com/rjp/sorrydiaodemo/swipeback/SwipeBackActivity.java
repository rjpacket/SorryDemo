package com.rjp.sorrydiaodemo.swipeback;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * author : Gimpo create on 2018/3/26 18:05
 * email  : jimbo922@163.com
 */

public class SwipeBackActivity extends AppCompatActivity {

    private View decorView;
    private float downX;
    private boolean isIntercept;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        decorView = getWindow().getDecorView();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        float rawX = ev.getRawX();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downX = rawX;
                if(rawX < 50){
                    isIntercept = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isIntercept = false;
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float rawX = event.getRawX();
        if(isIntercept){
            switch (event.getAction()){
                case MotionEvent.ACTION_MOVE:
                    float dx = rawX - downX;
                    decorView.setLeft((int) (decorView.getLeft() + dx));
                    downX = rawX;
                    break;
            }
            return true;
        }
        return super.onTouchEvent(event);
    }
}
