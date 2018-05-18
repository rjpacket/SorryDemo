package com.rjp.sorrydiaodemo;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.Toast;

import com.rjp.sorrydiaodemo.blur.BlurUtils;
import com.rjp.sorrydiaodemo.bookaidl.BookServiceManager;

import java.util.ArrayList;

public class SpecialGridViewActivity extends FragmentActivity {

    private Context mContext;
    private ArrayList<String> strings;

    public static final String SERVER_ACTION = "android.intent.action.aidl.bookservice";
    public static final String SERVER_PACKAGE_NAME = "com.rjp.aidlserver";
    private BookServiceManager bookServiceManager;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_grid_view);
        mContext = this;

        bookServiceManager = BookServiceManager.getInstance(mContext);
        bookServiceManager.connectService(SERVER_ACTION, SERVER_PACKAGE_NAME);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(BlurUtils.blurBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.top_pic), 25.0f, this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindService(mServiceConnection);
        bookServiceManager.unbindService();
    }

    private ComputeInterface mRemote = null;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //优化对远程的service代理
            mRemote = ComputeInterface.Stub.asInterface(service);
            Toast.makeText(mContext, "绑定成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mRemote = null;
            Toast.makeText(mContext, "远程服务链接已断", Toast.LENGTH_SHORT).show();
        }
    };

    public int getHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public void toast(String msg){
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
