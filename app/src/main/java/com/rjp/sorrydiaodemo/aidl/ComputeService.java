package com.rjp.sorrydiaodemo.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import com.rjp.sorrydiaodemo.ComputeInterface;

public class ComputeService extends Service {
    public ComputeService() {
    }

    private Binder sBinder = new ComputeInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int compute(int a, int b) throws RemoteException {
            return a + b;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return sBinder;
    }
}
