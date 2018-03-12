package com.rjp.sorrydiaodemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * author : Gimpo create on 2018/3/12 18:48
 * email  : jimbo922@163.com
 */

public class SpecialGridView extends GridView{
    private int editedIndex = -1;
    private Context mContext;

    public SpecialGridView(Context context) {
        super(context);
        mContext = context;
    }

    public SpecialGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        if(editedIndex != -1) {
            if(editedIndex % 2 == 0){ //点击了左边
                int index = editedIndex - getFirstVisiblePosition();
                ViewGroup editedView = (ViewGroup) getChildAt(index);
                View moveView = editedView.getChildAt(1);
                moveView.layout(moveView.getLeft() + dp2px(mContext, 40), moveView.getTop(), moveView.getRight() + dp2px(mContext, 40), moveView.getBottom());

                ViewGroup nextView = (ViewGroup) getChildAt(index + 1);
                if(nextView != null) {
                    nextView.layout(nextView.getLeft() + dp2px(mContext, 40), nextView.getTop(), nextView.getRight() + dp2px(mContext, 40), nextView.getBottom());
                }
            }else{ //点击了右边
                int index = editedIndex - getFirstVisiblePosition();
                ViewGroup editedView = (ViewGroup) getChildAt(index);
                View moveView = editedView.getChildAt(0);
                moveView.layout(moveView.getLeft() - dp2px(mContext, 40), moveView.getTop(), moveView.getRight() - dp2px(mContext, 40), moveView.getBottom());

                ViewGroup previousView = (ViewGroup) getChildAt(index - 1);
                previousView.layout(previousView.getLeft() - dp2px(mContext, 40), previousView.getTop(), previousView.getRight() - dp2px(mContext, 40), previousView.getBottom());
            }
        }
    }

    public int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void setEditedIndex(int editedIndex) {
        this.editedIndex = editedIndex;
    }
}
