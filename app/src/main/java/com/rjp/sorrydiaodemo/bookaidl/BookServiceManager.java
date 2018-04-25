package com.rjp.sorrydiaodemo.bookaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * author : Gimpo create on 2018/4/25 19:06
 * email  : jimbo922@163.com
 */
public class BookServiceManager {

    private final Context mContext;

    BookInterface mService;

    public BookServiceManager(Context mContext) {
        this.mContext = mContext;
    }

    private static BookServiceManager msm;

    public static BookServiceManager getInstance(Context context) {
        if (msm == null) {
            msm = new BookServiceManager(context);
        }
        return msm;
    }

    public BookInterface getMyService() {
        return mService;
    }

    /**
     * 连接服务  开启服务需要时间，应该提前调用
     *
     * @param serviceAction
     */
    public void connectService(String serviceAction, String serverPackageName) {
        if (mService == null) {
            Intent intent = new Intent();
            intent.setAction(serviceAction);
            intent.setPackage(serverPackageName);
            mContext.bindService(intent, conn, Context.BIND_AUTO_CREATE);
        }
    }

    /**
     * 解除服务
     */
    public void unbindService(){
        mContext.unbindService(conn);
    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = BookInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };
}
