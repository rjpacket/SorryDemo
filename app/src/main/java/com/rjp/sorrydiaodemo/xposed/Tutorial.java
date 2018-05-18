package com.rjp.sorrydiaodemo.xposed;

import android.annotation.SuppressLint;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Tutorial implements IXposedHookLoadPackage {

    public static final String IS_STEP_OPEN = "is_step_open";
    public static final String CUR_STEP_MULT = "cur_step_multiple";
    public static final String IS_CQ_OPEN = "is_cq_open";
    public static final String IS_TZ_OPEN = "is_tz_open";
    public static final String CUR_CQ_NUM = "cur_cq_num";
    public static final String CUR_TZ_NUM = "cur_cq_num";

    private XSharedPreferences xsp = MySP.getInstance();

    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("Loaded app: " + lpparam.packageName);

        if (!lpparam.packageName.equals("com.tencent.mm"))
            return;

        @SuppressLint("PrivateApi") Class<?> aClass = Class.forName("android.hardware.SystemSensorManager$SensorEventQueue");
        XposedBridge.hookAllMethods(aClass, "dispatchSensorEvent", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                xsp.reload();
//                if(xsp.getBoolean(IS_STEP_OPEN, true)){
                    int anInt = 10;
                    float[] arg = (float[]) param.args[1];
                    arg[0] *= anInt;
//                }
                super.beforeHookedMethod(param);
            }
        });
    }
}