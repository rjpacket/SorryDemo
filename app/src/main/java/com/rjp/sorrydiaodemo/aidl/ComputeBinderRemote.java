package com.rjp.sorrydiaodemo.aidl;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * author : Gimpo create on 2018/4/25 16:49
 * email  : jimbo922@163.com
 */
public class ComputeBinderRemote extends Binder implements ComputeInterface {
    @Override
    public int compute(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        if (code == GET_PRICE_CODE) {
            int a = data.readInt();
            int b = data.readInt();
            int compute = compute(a, b);
            reply.writeInt(compute);
            return true;
        }
        return super.onTransact(code, data, reply, flags);
    }
}
