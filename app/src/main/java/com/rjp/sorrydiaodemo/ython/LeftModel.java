package com.rjp.sorrydiaodemo.ython;

/**
 *
 * 竖轴的model
 * author : Gimpo create on 2018/4/9 17:26
 * email  : jimbo922@163.com
 */

public class LeftModel {
    private String title;

    private int x0;
    private int y0;

    private int x1;
    private int y1;

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

    public LeftModel(String title){
        this.title = title;
    }

    public void setLocation(int x0, int y0, int x1, int y1){
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
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
