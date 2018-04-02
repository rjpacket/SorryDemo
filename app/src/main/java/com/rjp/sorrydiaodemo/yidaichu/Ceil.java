package com.rjp.sorrydiaodemo.yidaichu;

/**
 * author : Gimpo create on 2018/4/2 18:04
 * email  : jimbo922@163.com
 */

public class Ceil {
    private int left;
    private int top;
    private int right;
    private int bottom;

    private int centerX;
    private int centerY;

    public void setLocation(int left, int right, int top, int bottom){
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;

        centerX = (int) ((left + right) / 2);
        centerY = (int) ((top + bottom) / 2);
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
