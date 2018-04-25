package com.rjp.sorrydiaodemo.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * client 获取的是远程 server binder 的代理类
 * author : Gimpo create on 2018/4/25 16:43
 * email  : jimbo922@163.com
 */
public class ComputeBinderProxy implements ComputeInterface {
    private IBinder mRemote;

    public ComputeBinderProxy(IBinder binder){
        mRemote = binder;
    }

    @Override
    public int compute(int a, int b) throws RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
            _data.writeInt(a);
            _data.writeInt(b);
            mRemote.transact(1, _data, _reply, 0);
            _result = _reply.readInt();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

    public static ComputeInterface asInterface(android.os.IBinder obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Binder) {
            Log.d("---------->", "asInterface :  obj instanceof Binder");
            return (ComputeInterface) obj;
        } else {
            Log.d("---------->", "asInterface :  obj instanceof GameBinderProxy");
            return new ComputeBinderProxy(obj);
        }
    }
}
