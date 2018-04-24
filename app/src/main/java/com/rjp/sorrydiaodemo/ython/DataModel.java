package com.rjp.sorrydiaodemo.ython;

/**
 *
 * 数据model
 * author : Gimpo create on 2018/4/9 17:35
 * email  : jimbo922@163.com
 */

public class DataModel {

    private int number;

    private int dx;
    private int dy;

    public DataModel(int number){
        this.number = number;
    }

    public void setLocation(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
