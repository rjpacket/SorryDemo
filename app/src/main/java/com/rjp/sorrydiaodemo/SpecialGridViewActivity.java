package com.rjp.sorrydiaodemo;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rjp.sorrydiaodemo.bookaidl.Book;
import com.rjp.sorrydiaodemo.bookaidl.BookInterface;
import com.rjp.sorrydiaodemo.bookaidl.BookServiceManager;

import java.util.ArrayList;
import java.util.List;

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

        final Button btnSum = (Button) findViewById(R.id.btn_jisuan);
        findViewById(R.id.btn_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BookInterface myService = bookServiceManager.getMyService();
                try {
                    if(myService != null) {
                        List<Book> books = myService.getBooks();
                        Book book = books.get(0);
                        btnSum.setText(book.getName());
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int sum = mRemote.compute(1, 2);
                    btnSum.setText(String.valueOf(sum));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
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
