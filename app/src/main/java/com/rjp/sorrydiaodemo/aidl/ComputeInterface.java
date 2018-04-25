package com.rjp.sorrydiaodemo.aidl;

import android.os.RemoteException;

/**
 * author : Gimpo create on 2018/4/25 16:42
 * email  : jimbo922@163.com
 */
public interface ComputeInterface {
    public static final int GET_PRICE_CODE = 1;   //响应码

    int compute(int a, int b) throws RemoteException;
}
