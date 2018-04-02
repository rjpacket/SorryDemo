package com.rjp.sorrydiaodemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.GridView;

/**
 * author : Gimpo create on 2018/3/12 18:48
 * email  : jimbo922@163.com
 */

public class SpecialGridView extends GridView {
    private int editedIndex = -1;
    private int lastEditedIndex = -1;
    private Context mContext;
    private int defaultTranslateX = 40;

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
        resetLastEditView();
        activateEditView();
    }

    public void setEditedIndex(int index) {
        lastEditedIndex = editedIndex;
        this.editedIndex = index;
    }

    /**
     * 激活view处于编辑状态
     */
    public void activateEditView() {
        optionEditView(editedIndex, true);
    }

    /**
     * 复原上个编辑状态的view
     */
    public void resetLastEditView() {
        optionEditView(lastEditedIndex, false);
    }

    /**
     * 更改view状态
     * @param optionIndex 更改状态的view的下标
     * @param isEditable  当前view是否处于编辑状态
     */
    public void optionEditView(int optionIndex, boolean isEditable) {
        if (optionIndex != -1) {
            if (optionIndex % 2 == 0) { //点击了左边
                int index = optionIndex - getFirstVisiblePosition();
                ViewGroup editedView = (ViewGroup) getChildAt(index);
                View moveView = editedView.getChildAt(0);
                translateX(moveView, isEditable, true);

                ViewGroup nextView = (ViewGroup) getChildAt(index + 1);
                if (nextView != null) {
                    translateX(nextView, isEditable, true);
                }
            } else { //点击了右边
                int index = optionIndex - getFirstVisiblePosition();
                ViewGroup editedView = (ViewGroup) getChildAt(index);
                View moveView = editedView.getChildAt(1);
                translateX(moveView, isEditable, false);

                ViewGroup previousView = (ViewGroup) getChildAt(index - 1);
                translateX(previousView, isEditable, false);
            }
        }
    }

    public void translateX(View view, boolean isEditable, boolean isPositive) {
        int translateX;
        if (isPositive) {
            translateX = dp2px(mContext, defaultTranslateX);
        } else {
            translateX = -dp2px(mContext, defaultTranslateX);
        }
        if (!isEditable) {
            translateX = 0;
        }
        ViewPropertyAnimator animate = view.animate();
        animate.translationX(translateX);
    }

    public int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
