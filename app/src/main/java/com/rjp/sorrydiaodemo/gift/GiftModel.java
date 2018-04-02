package com.rjp.sorrydiaodemo.gift;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.Random;

import static android.R.attr.animation;

/**
 * author : Gimpo create on 2018/3/30 15:38
 * email  : jimbo922@163.com
 */

public class GiftModel extends ImageView{

    public float x;
    public float y;
    private Random random;

    public GiftModel(Context context, int resId, PointF clickPoint){
        super(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(40, 40);
        setLayoutParams(params);
        setImageResource(resId);
        random = new Random();

        PointF nextPoint = new PointF(clickPoint.x + random.nextInt(200) - 100, clickPoint.y - random.nextInt(100) - 200);
        startAnim(clickPoint, nextPoint);
    }

    public GiftModel(Context context) {
        super(context);
    }

    public GiftModel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void startAnim(PointF startPoint, final PointF endPoint) {

        //大致取两个控制点
        PointF controlP1 = new PointF(startPoint.x - random.nextInt(20) - 30, startPoint.y - random.nextInt(40) - 60);
        PointF controlP2 = new PointF(endPoint.x + 30, endPoint.y + 60);
        ValueAnimator animator = ValueAnimator.ofObject(new BeizerEvaluator(controlP1, controlP2), startPoint, endPoint);
        animator.setDuration(random.nextInt(100) + 1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF curPoint = (PointF) animation.getAnimatedValue();
                x = curPoint.x;
                y = curPoint.y;
                layout((int)x, (int)y, (int)(x + 40), (int)(y + 40));
            }
        });
        animator.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(y > 0){
                    PointF nextPoint = new PointF(endPoint.x, endPoint.y - random.nextInt(100) - 200);
                    startAnim(endPoint, nextPoint);
                }else{
                    ViewGroup parent = (ViewGroup) getParent();
                    if(parent != null){
                        parent.removeView(GiftModel.this);
                    }
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
