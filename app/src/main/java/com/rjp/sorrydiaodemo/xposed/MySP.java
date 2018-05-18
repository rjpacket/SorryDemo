package com.rjp.sorrydiaodemo.xposed;

import de.robv.android.xposed.XSharedPreferences;

/**
 * author : Gimpo create on 2018/4/28 18:22
 * email  : jimbo922@163.com
 */
public class MySP {
    private static XSharedPreferences xsp;

    public static XSharedPreferences getInstance() {
        if(xsp == null){
            xsp = new XSharedPreferences("com.rjp.sorrydiaodemo", "config");
            xsp.makeWorldReadable();
        }else{
            xsp.reload();
        }
        return xsp;
    }
}
