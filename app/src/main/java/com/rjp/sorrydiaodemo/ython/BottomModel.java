package com.rjp.sorrydiaodemo.ython;

/**
 *
 * 横轴的model
 * author : Gimpo create on 2018/4/9 17:30
 * email  : jimbo922@163.com
 */

public class BottomModel {
    private String title;

    private int bx;
    private int by;

    private int left;
    private int top;
    private int right;
    private int bottom;

    private int midX;
    private int midY;

    public void setRect(int left, int top, int right, int bottom){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        midX = (left + right) / 2;
        midY = (top + bottom) / 2;
    }

    public BottomModel(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBx() {
        return bx;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public int getBy() {
        return by;
    }

    public void setBy(int by) {
        this.by = by;
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

    public int getMidX() {
        return midX;
    }

    public void setMidX(int midX) {
        this.midX = midX;
    }

    public int getMidY() {
        return midY;
    }

    public void setMidY(int midY) {
        this.midY = midY;
    }
}
