package com.rjp.sorrydiaodemo.ython;

/**
 * author : Gimpo create on 2018/4/9 18:03
 * email  : jimbo922@163.com
 */

public class StandardModel {

    private int number;

    private int sx;
    private int sy;

    public StandardModel(int number){
        this.number = number;
    }

    public void setLocation(int sx, int sy){
        this.sx = sx;
        this.sy = sy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSx() {
        return sx;
    }

    public void setSx(int sx) {
        this.sx = sx;
    }

    public int getSy() {
        return sy;
    }

    public void setSy(int sy) {
        this.sy = sy;
    }
}
