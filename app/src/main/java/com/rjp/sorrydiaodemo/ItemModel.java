package com.rjp.sorrydiaodemo;

/**
 * author : Gimpo create on 2018/3/12 19:43
 * email  : jimbo922@163.com
 */

public class ItemModel {
    private String title;
    private boolean isEdited;

    public ItemModel(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }
}
